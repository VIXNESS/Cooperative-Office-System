package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("app")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private AtmTranService atmTranService;

    @Autowired
    private RvFlowService rvFlowService;

    @RequestMapping(value = "pk",method = RequestMethod.POST)
    public @ResponseBody
    Callable<Application> getApplicationByPk(String pk){
        return new Callable<Application>() {
            @Override
            public Application call() throws Exception {
                return applicationService.getByPk(pk);
            }
        };
    }

    @RequestMapping(value = "usr", method = RequestMethod.POST)
    public @ResponseBody
    Callable<List<Application>> getApplicationsByUser(HttpSession session,int page,int row){
        String uid = (String) session.getAttribute("currentUser");
        return new Callable<List<Application>>() {
            @Override
            public List<Application> call() throws Exception {
                ApplicationCriteria applicationCriteria = new ApplicationCriteria();
                applicationCriteria.or()
                        .andApActorEqualTo(uid);
                return applicationService.get(applicationCriteria,page,row);
            }
        };
    }

    @RequestMapping(value = "rvw", method = RequestMethod.POST)
    public @ResponseBody
    Callable<List<Application>> getApplicationByReviewer(HttpSession session, int page, int row){
        String uid = (String) session.getAttribute("currentUser");
        return new Callable<List<Application>>() {
            @Override
            public List<Application> call() throws Exception {
                Staff staff = staffService.getByPk(uid);
                OfficeCriteria officeCriteria = new OfficeCriteria();
                officeCriteria.or()
                        .andStaffEqualTo(staff.getId());
                List<Office> officeList = officeService.get(officeCriteria);
                List<AtmTran> atmTrans = new ArrayList<>();
                for(Office o : officeList){
                    AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
                    atmTranCriteria.or()
                            .andRvDpEqualTo(o.getDepartment()).andRvPosiEqualTo(o.getPosi());
                     atmTrans.addAll(atmTranService.get(atmTranCriteria));
                }
                Set<RvFlow> rvFlowKeySet = Collections.synchronizedSet(new HashSet<>());
                for(AtmTran a : atmTrans){
                    RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
                    rvFlowCriteria.or().andAtmEqualTo(a.getPk());
                    rvFlowKeySet.addAll(new HashSet<>(rvFlowService.get(rvFlowCriteria)));
                }

                List<Application> applicationList = new ArrayList<>();
                for(RvFlow r : rvFlowKeySet){
                    ApplicationCriteria applicationCriteria = new ApplicationCriteria();
                    applicationCriteria.or().andPtrEqualTo(r.getPk());
                    applicationList.addAll(applicationService.get(applicationCriteria,page,row));
                }
                return applicationList;
            }
        };
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody
    Callable<String> addApplication(String rv,String comment,HttpSession session)throws Exception{
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                String uid = (String) session.getAttribute("currentUser");
                String uniqueID = UUID.randomUUID().toString().substring(0,8);
                Application application = new Application();
                application.setApPk(uniqueID);
                application.setRvPk(rv);
                application.setApActor(uid);
                application.setApComment(comment);
                application.setApDate(new Date());
                application.setPtr("");
                try {
                    applicationService.insert(application);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
                return "true";
            }
        };
    }

    @RequestMapping(value = "upc",method = RequestMethod.POST)
    public @ResponseBody
    Callable<String> updateComment(String ap,String comment)throws Exception{
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Application application = new Application();
                application.setApComment(comment);
                application.setApPk(ap);
                return Integer.toString(applicationService.update(application));
            }
        };
    }

    @RequestMapping(value = "ups",method = RequestMethod.POST)
    public @ResponseBody
    Callable<String> updateStat(String pk,String ptr)throws Exception{
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Application application = new Application();
                application.setApPk(pk);
                application.setPtr(ptr);
                return Integer.toString(applicationService.update(application));
            }
        };
    }
    @RequestMapping(value = "addToFlow",method = RequestMethod.POST)
    public @ResponseBody
    String addToRvFlow(String app) throws Exception {
        //应该交由判定机构来做
        Application application = applicationService.getByPk(app);
        if(application == null || application.getPtr() != null)return "error";
        RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
        rvFlowCriteria.or().andObjEqualTo(application.getRvPk()).andPreIsNull();
        RvFlow rvFlow = rvFlowService.get(rvFlowCriteria).get(0);
        application.setPtr(rvFlow.getPk());
        return Integer.toString(applicationService.update(application));

    }
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public @ResponseBody
    Callable<String> deleteApplication(String pk)throws Exception{
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Integer.toString(applicationService.delete(pk));
            }
        };
    }

    @RequestMapping(value = "pass",method = RequestMethod.POST)
    public @ResponseBody
    String passApp(String apk) throws Exception {
        Application application = applicationService.getByPk(apk);
        if(application == null) return "null_app";
        if(application.getPtr() == null || application.getPtr().equals("")) return "null_ptr";
        if(application.getRvPk() == null || application.getRvPk().equals("")) return "null_obj";
        RvFlow rvFlow = rvFlowService.getByPk(application.getPtr());
        if(rvFlow.getSuc() == null || rvFlow.getSuc().equals("")) return "finished";
        application.setPtr(rvFlow.getSuc());
        return Integer.toString(applicationService.update(application));
    }
}
