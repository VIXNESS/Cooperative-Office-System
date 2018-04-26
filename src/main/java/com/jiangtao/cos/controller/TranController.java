package com.jiangtao.cos.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("trn")
public class TranController {

    private final RvFlowService rvFlowService;

    private final RvObjectService rvObjectService;

    private final AtmTranService atmTranService;

    private final DepartmentService departmentService;

    private final PositionService positionService;

    private final AppTemplateService appTemplateService;

    @Autowired
    public TranController(RvFlowService rvFlowService, RvObjectService rvObjectService, AtmTranService atmTranService, DepartmentService departmentService, PositionService positionService, AppTemplateService appTemplateService) {
        this.rvFlowService = rvFlowService;
        this.rvObjectService = rvObjectService;
        this.atmTranService = atmTranService;
        this.departmentService = departmentService;
        this.positionService = positionService;
        this.appTemplateService = appTemplateService;
    }

    //审批对象部分

    @PostMapping("addObj")
    public @ResponseBody
    String addRvObj(@RequestBody Map request){
        String name = (String) request.get("name");
        String type = (String) request.get("type");
        RvObject rvObject = new RvObject();
        rvObject.setObjName(name);
        rvObject.setType(type);
        rvObject.setObjPk(UUID.randomUUID().toString().substring(0,8));
        return Integer.toString(rvObjectService.insert(rvObject));
    }

    @PostMapping("updObj")
    public @ResponseBody
    String updateRvObj(@RequestBody Map request){
        String id = (String) request.get("id");
        String name = (String) request.get("name");
        String type = (String) request.get("type");
        if(id == null||id.equals("")) return "null";
        RvObject rvObject = new RvObject();
        if(!(name == null || name.equals(""))) rvObject.setObjName(name);
        rvObject.setObjPk(id);
        if(!(type == null || type.equals(""))) rvObject.setType(type);
        return Integer.toString(rvObjectService.update(rvObject));
    }

    @PostMapping("delObj")
    public @ResponseBody
    String deleteRvObj(@RequestBody Map request) throws Exception {
        String id = (String) request.get("id");
        RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
        rvFlowCriteria.or().andObjEqualTo(id);
        rvFlowService.delete(rvFlowCriteria);
        return Integer.toString(rvObjectService.delete(id));
    }

    @GetMapping("getObj")
    public @ResponseBody
    Callable<List<RvObject>> getRvObj(){
        return () -> {
            RvObjectCriteria rvObjectCriteria = new RvObjectCriteria();
            rvObjectCriteria.or().andObjPkIsNotNull();
            return rvObjectService.get(rvObjectCriteria);
        };
    }

    @GetMapping("getObjPage")
    public @ResponseBody
    Callable<List<RvObject>> getRvObjPage(Integer page,Integer row){
        return () -> {
            RvObjectCriteria rvObjectCriteria = new RvObjectCriteria();
            rvObjectCriteria.or().andObjPkIsNotNull();
            return rvObjectService.get(rvObjectCriteria,page,row);
        };
    }


    //工作流部分

    @RequestMapping(value="addFlowList", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public @ResponseBody
    String addRvFlowList(@RequestBody String params) throws Exception {
        TypeReference<List<FlowWrapper>> typeReference = new TypeReference<List<FlowWrapper>>(){};
        List<FlowWrapper> flowWrappers = JSON.parseObject(params,typeReference);
        String objKey = flowWrappers.get(flowWrappers.size() - 1).getPk();
        flowWrappers.remove(flowWrappers.size() -1);
        RvFlow rvFlow;
        RvFlow preFlow = null;
        List<RvFlow> rvFlowList = new ArrayList<>();
        for(FlowWrapper flowWrapper: flowWrappers){
             rvFlow = new RvFlow();
             rvFlow.setPk(UUID.randomUUID().toString().substring(0,8));
             rvFlow.setAtm(flowWrapper.getPk());
             rvFlow.setObj(objKey);
             if(flowWrapper.getIndex().equals(0)){
                 rvFlowList.add(rvFlow);
                 preFlow = rvFlow;
             }else if(!(flowWrapper.getIndex().equals(flowWrappers.size() - 1))){
                 preFlow.setSuc(rvFlow.getPk());
                 rvFlow.setPre(preFlow.getPk());
                 rvFlowList.add(rvFlow);
                 preFlow = rvFlow;
             }else{
                 preFlow.setSuc(rvFlow.getPk());
                 rvFlow.setPre(preFlow.getPk());
                 rvFlowList.add(rvFlow);
                 break;
             }
        }
        for(RvFlow temp : rvFlowList){
            rvFlowService.add(temp);
        }
        return "success";
    }

    @RequestMapping(value="delFlowList", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public @ResponseBody
    String deleteRvFlow(@RequestBody String params) {
        TypeReference<List<FlowWrapper>> typeReference = new TypeReference<List<FlowWrapper>>(){};
        List<FlowWrapper> flowWrappers = JSON.parseObject(params,typeReference);
        try{
            for(FlowWrapper wrapper: flowWrappers){
                rvFlowService.delete(wrapper.getPk());
            }
        }catch (Exception e){
            return "error";
        }
        return "success";
    }

    @RequestMapping(value="updateFlow", method=RequestMethod.POST)
    public @ResponseBody
    String updateRvFLow(@RequestBody Map request){
         String atmPk = (String) request.get("atm");
         String rvPk = (String) request.get("rv");
         RvFlow rvFlow = rvFlowService.getByPk(rvPk);
         rvFlow.setAtm(atmPk);
         return Integer.toString(rvFlowService.update(rvFlow));
    }

    @RequestMapping(value="updateFlowList", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public @ResponseBody
    String updateRvFlowList(@RequestBody String params){
        TypeReference<List<FlowWrapper>> typeReference = new TypeReference<List<FlowWrapper>>(){};
        List<FlowWrapper> flowWrappers = JSON.parseObject(params,typeReference);
        if(flowWrappers.size() < 2) return "error";
        List<RvFlow> rvFlowList = new ArrayList<>();
        for(FlowWrapper f : flowWrappers){
            rvFlowList.add(rvFlowService.getByPk(f.getPk()));
        }

        if(rvFlowList.size() > 2){
            RvFlow pre, cur, suc;
            for(int i = 1; i < rvFlowList.size() - 1; i++){
                pre = rvFlowList.get(i - 1);
                cur = rvFlowList.get(i);
                suc = rvFlowList.get(i + 1);
                cur.setPre(pre.getPk());
                pre.setSuc(cur.getPk());
                cur.setSuc(suc.getPk());
                suc.setPre(cur.getPk());
            }
            rvFlowList.get(0).setPre(null);
            rvFlowList.get(rvFlowList.size() - 1).setSuc(null);
            rvFlowList.get(rvFlowList.size() - 1).setPre(rvFlowList.get(rvFlowList.size() - 2).getPk());
        }else if(rvFlowList.size() == 2){
            rvFlowList.get(0).setSuc(rvFlowList.get(1).getPk());
            rvFlowList.get(0).setPre(null);
            rvFlowList.get(1).setPre(rvFlowList.get(0).getPk());
            rvFlowList.get(1).setSuc(null);
        }
        for(RvFlow r : rvFlowList){
            rvFlowService.update(r);
        }
        return "success";
    }

    /**
     *
     * @return
     *  FlowList Object: [ flowView, flowView, flowView],
     *  FlowView Object: {
     *    primary key: pk,
     *    Forerunner : pre,
     *    successor : suc,
     *    atomic transaction: atm,
     *    review object primary key: obj,
     *    review object name: objName
     *  },
     *  Atm Object: {
     *      primary key: pk,
     *      position name: pName,
     *      department name: department,
     *      atomic transaction comment: atmComment
     *  }
     */
    public List<RvFlowView> makeRvFlowViewList(List<RvFlow> rvFlowList) throws Exception {
        List<RvFlowView> rvFlowViews = new ArrayList<>();
        RvFlowView flowView;
        for(RvFlow rvFlow: rvFlowList){
            AtmTran atmTran = atmTranService.getByPk(rvFlow.getAtm());
            flowView = new RvFlowView();
            flowView.setObjName(rvObjectService.getByPk(rvFlow.getObj()).getObjName());
            flowView.setObj(rvFlow.getObj());
            flowView.setPk(rvFlow.getPk());
            flowView.setSuc(rvFlow.getSuc());
            flowView.setPre(rvFlow.getPre());
            flowView.setAtm("{ \"atmPk\": \"" + rvFlow.getAtm() + "\", \"pName\": \"" + positionService.getByPk(atmTran.getRvPosi()).getPosiName() + "\", \"dName\": \"" + departmentService.getByPk(atmTran.getRvDp()).getName() + "\" }");
            flowView.setAtmComment(atmTran.getAtmComment());
            rvFlowViews.add(flowView);
        }
        return rvFlowViews;
    }


    /**
     * @return All FlowList : [ flowViewListObject, flowViewListObject, flowViewListObject ...]
     */
    @GetMapping("flowList")
    public @ResponseBody
    Callable<List<List<RvFlowView>>> getFlowList() {
       return () -> {
           RvObjectCriteria rvObjectCriteria = new RvObjectCriteria();
           rvObjectCriteria.or().andObjPkIsNotNull();
           List<RvObject> rvObjectList = rvObjectService.get(rvObjectCriteria);// get all RvObject.

           List<List<RvFlowView>> rvFlowViewsList = new ArrayList<>();
           for(RvObject rvObject : rvObjectList){
               RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
               rvFlowCriteria.or().andObjEqualTo(rvObject.getObjPk());
               List<RvFlow> rvFlowList = rvFlowService.get(rvFlowCriteria);// get rvFlowList(unserializable,it's a block of flowViews) from a RvObject.
               rvFlowViewsList.add(makeRvFlowViewList(rvFlowList));// make rvFlowList into rvFlowViewList.
           }
           return rvFlowViewsList;//let frontend to serialize flowViewLists
       };
    }

    @GetMapping("getFlowByObj")
    public @ResponseBody
    Callable<List<RvFlowView>> getFlowListByObjPk(String objPk){
        return () ->{
          RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
          rvFlowCriteria.or().andObjEqualTo(objPk);
          return makeRvFlowViewList(rvFlowService.get(rvFlowCriteria));
        };
    }

    @GetMapping("countFlowByObj")
    public @ResponseBody
    Callable<Long> countFlowsByObj(String objPk){
        return () -> {
          RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
          rvFlowCriteria.or().andObjEqualTo(objPk);
          return rvFlowService.count(rvFlowCriteria);
        };
    }

    @GetMapping("flowListByFirstNode")
    public @ResponseBody
    Callable<List<RvFlowView>> getFlowListByFirstNode(String firstNode){
        return () -> {
            List<RvFlow> rvFlowList = new ArrayList<>();
            RvFlow current =  rvFlowService.getByPk(firstNode);
            rvFlowList.add(current);
            while(current.getSuc() != null){
                current = rvFlowService.getByPk(current.getSuc());
                rvFlowList.add(current);
            };
            return makeRvFlowViewList(rvFlowList);
        };
    }

    @GetMapping("isLastStep")
    public @ResponseBody
    Callable<String> isLastStep(String ptr){
        return () -> {
            RvFlow rvFlow = rvFlowService.getByPk(ptr);
            if(rvFlow.getSuc() == null) return "true";
            else return "false";
        };
    }
    //原子事物部分

    @GetMapping(value = "getAtms")
    public @ResponseBody
    Callable<List<AtmView>> getAllAtm(Integer page,Integer row){
        return () -> {
            if(page == null || row == null) return null;
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andPkIsNotNull();
            List<AtmTran> atmTranList;
            if(row.equals(0)){
               atmTranList = atmTranService.get(atmTranCriteria);
            }else {
                atmTranList = atmTranService.get(atmTranCriteria,page,row);
            }
            List<AtmView> atmViewList = new ArrayList<>();
            for(AtmTran a: atmTranList){
                AtmView temp = new AtmView();
                temp.setAtmTran(a);
                temp.setDpm(departmentService.getByPk(a.getRvDp()).getName());
                temp.setPosi(positionService.getByPk(a.getRvPosi()).getPosiName());
                atmViewList.add(temp);
            }
            return atmViewList;
        };
    }

    @GetMapping("countAtm")
    public @ResponseBody
    Callable<Long> countAtmTrans(){
        return () -> {
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andPkIsNotNull();
            return atmTranService.countAtms(atmTranCriteria) ;
        };
    }

    @GetMapping("getAtmByDpm")
    public @ResponseBody
    Callable<List<AtmTran>> getAtmByDepartment(String department){
        return () -> {
            if(department == null || department.equals("")) return null;
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andRvDpEqualTo(department);
            return atmTranService.get(atmTranCriteria);
        };
    }

    @GetMapping("getAtmByOfc")
    public @ResponseBody
    Callable<List<AtmTran>> getAtmByOffice(String department,int position,int page,int row){
        return () -> {
            if(department == null || department.equals("")) return null;
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andRvDpEqualTo(department).andRvPosiEqualTo((byte) position);
            return atmTranService.get(atmTranCriteria,page,row);
        };
    }

    @PostMapping("addAtm")
    public @ResponseBody
    String addAtm(@RequestBody Map request) throws Exception {
        String department = (String)request.get("d");
        Integer rp = (Integer) request.get("p");
        Byte position = rp.byteValue();
        String comment = (String)request.get("c");
        if(department == null || department.equals("")) return "error";
        if(comment == null || comment.equals("")) return "error";
        if(position == null) return "error";
        AtmTran atmTran = new AtmTran();
        atmTran.setAtmComment(comment);
        atmTran.setRvDp(department);
        atmTran.setRvPosi(position);
        atmTran.setPk(UUID.randomUUID().toString().substring(0,8));
        return Integer.toString(atmTranService.insert(atmTran));
    }

    @PostMapping("updAtm")
    public @ResponseBody
    String updateAtm(@RequestBody Map request) throws Exception {
        String pk = (String) request.get("pk");
        String comment = (String) request.get("comment");
        String department = (String) request.get("department");
        Integer pp = (Integer) request.get("position");
        if(pp == null || pk == null ||comment == null || department == null) return "error";
        Byte position = pp.byteValue();
        if(pk.equals("")) return "error";
        AtmTran atmTran = atmTranService.getByPk(pk);
        atmTran.setRvPosi(position);
        atmTran.setRvDp(department);
        if(!comment.equals("")) atmTran.setAtmComment(comment);
        return Integer.toString(atmTranService.update(atmTran));
    }

    @PostMapping("delAtm")
    public @ResponseBody
    String deleteAtm(@RequestBody Map request) throws Exception {
        String pk = (String) request.get("pk");
        if(pk == null || pk.equals("")) return "error";
        return Integer.toString(atmTranService.delete(pk));
    }

//    模板
    @PostMapping("addTep")
    public @ResponseBody
    String addTemplate(@RequestBody Map request){
        String objPk = (String) request.get("pk");
        String jsonStr = (String) request.get("data");
        AppTemplate appTemplate = appTemplateService.selectByPk(objPk);
        if(appTemplate != null){
            appTemplate.setTemplate(jsonStr);
            appTemplateService.update(appTemplate);
        }else {
            appTemplate = new AppTemplate();
            appTemplate.setPk(UUID.randomUUID().toString().substring(0,8));
            appTemplate.setObjpk(objPk);
            appTemplate.setTemplate(jsonStr);
            appTemplateService.insert(appTemplate);
        }
        return "success";
    }

    @GetMapping("getTepByObj")
    public @ResponseBody
    Callable<String> getTemplateByObj(String obj){
        return () -> {
            String rs = "null";
            try{
                rs = appTemplateService.selectByObjPk(obj).getTemplate();
            }catch (Exception e){
                e.printStackTrace();
            }
            return rs;
        };
    }

    @GetMapping("getTepByPk")
    public @ResponseBody
    Callable<String> getTemplateByPk(String pk){
        return () -> {
            String rs = "null";
            try{
                rs = appTemplateService.selectByPk(pk).getTemplate();
            }catch (Exception e){
                e.printStackTrace();
            }
            return rs;
        };
    }

    @GetMapping("getTepPk")
    public @ResponseBody
    Callable<String> getTepByObjPk(String obj){
        return () -> {
            String rs = "null";
            try{
                rs = appTemplateService.selectByObjPk(obj).getPk();
            }catch (Exception e){
                e.printStackTrace();
            }
            return rs;
        };
    }

    @GetMapping("getTps")
    public @ResponseBody
    Callable<List<TemplateView>> getTemplateList(){
        return () -> {
            List<TemplateView> templateViewList = new ArrayList<>();
            List<AppTemplate> appTemplateList = appTemplateService.selectAll();
            TemplateView templateView;
            for(AppTemplate template : appTemplateList){
                if(template.getObjpk() != null){
                    templateView = new TemplateView();
                    templateView.setPk(template.getPk());
                    templateView.setData(template.getTemplate());
                    templateView.setObjPk(template.getObjpk());
                    templateView.setObjName(rvObjectService.getByPk(template.getObjpk()).getObjName());
                    templateViewList.add(templateView);
                }
            }
            return templateViewList;
        };
    }

    @PostMapping("delTps")
    public @ResponseBody
    String deleteTemplateByObjPk(@RequestBody Map request){
        String pk = (String) request.get("pk");
        appTemplateService.delete(pk);
        return "success";
    }

}
