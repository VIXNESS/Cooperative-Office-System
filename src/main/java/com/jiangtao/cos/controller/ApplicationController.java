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
@Scope("session")
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

    @Autowired
    private RvObjectService rvObjectService;

    @RequestMapping("pk")
    public @ResponseBody
    Callable<Application> getApplicationByPk(String pk){
        return new Callable<Application>() {
            @Override
            public Application call() throws Exception {
                return applicationService.getByPk(pk);
            }
        };
    }

    @RequestMapping("usr")
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

    @RequestMapping("rvw")
    public @ResponseBody
    Callable<List<Application>> getApplicationByReviewer(HttpSession session, int page, int row){
        String uid = (String) session.getAttribute("currentUser");
        System.out.println("UID:                                :" + uid);//mark
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
                Set<RvFlowKey> rvFlowKeySet = Collections.synchronizedSet(new HashSet<>());
                for(AtmTran a : atmTrans){
                    RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
                    rvFlowCriteria.or().andAtPkEqualTo(a.getPk());
                    rvFlowKeySet.addAll(new HashSet<>(rvFlowService.get(rvFlowCriteria)));
                }

                List<Application> applicationList = new ArrayList<>();
                for(RvFlowKey r : rvFlowKeySet){
                    ApplicationCriteria applicationCriteria = new ApplicationCriteria();
                    applicationCriteria.or().andRvPkEqualTo(r.getRobjPk()).andApStatEqualTo(r.getRbojSerial());
                    applicationList.addAll(applicationService.get(applicationCriteria,page,row));
                }
                return applicationList;
            }
        };
    }

    @RequestMapping("add")
    public @ResponseBody
    Callable<String> addApplication(String rv,String comment,HttpSession session){
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
                application.setApStat((byte) 0);
                try {
                    applicationService.insert(application);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "false";
                }
                return "true";
            }
        }
    }

    @RequestMapping("upc")
    public @ResponseBody
    Callable<String> updateComment(String ap,String comment){
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

    @RequestMapping("ups")
    public @ResponseBody
    Callable<String> updateStat(String pk,int stat){
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Application application = new Application();
                application.setApPk(pk);
                application.setApStat((byte)stat);
                return Integer.toString(applicationService.insert(application));
            }
        };
    }
    @RequestMapping("del")
    public @ResponseBody
    Callable<String> deleteApplication(String pk){
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Integer.toString(applicationService.delete(pk));
            }
        };
    }
}
