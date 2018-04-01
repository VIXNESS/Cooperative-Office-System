package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import static com.jiangtao.cos.service.RvFlowService.HEAD;
import static com.jiangtao.cos.service.RvFlowService.MID;
import static com.jiangtao.cos.service.RvFlowService.TAIL;

@Controller
@RequestMapping("trn")
@CrossOrigin(origins = "http://localhost:3000")
public class TranController {

    @Autowired
    private RvFlowService rvFlowService;

    @Autowired
    private RvObjectService rvObjectService;

    @Autowired
    private AtmTranService atmTranService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @RequestMapping("addObj")
    public @ResponseBody
    String addRvObj(String name,String type) throws Exception {
        RvObject rvObject = new RvObject();
        rvObject.setObjName(name);
        rvObject.setType(type);
        rvObject.setObjPk(UUID.randomUUID().toString().substring(0,8));
        return Integer.toString(rvObjectService.insert(rvObject));
    }


    @RequestMapping("updObj")
    public @ResponseBody
    String updateRvObj(String id,String name,String type){
        if(id == null||id.equals("")) return "null";
        RvObject rvObject = new RvObject();
        if(!(name == null || name.equals(""))) rvObject.setObjName(name);
        rvObject.setObjPk(id);
        if(!(type == null || type.equals(""))) rvObject.setType(type);
        return Integer.toString(rvObjectService.update(rvObject));
    }

    @RequestMapping("delObj")
    public @ResponseBody
    String deleteRvObj(String id) throws Exception {
        return Integer.toString(rvObjectService.delete(id));
    }

    @RequestMapping("getObj")
    public @ResponseBody
    Callable<List<RvObject>> getRvObj(){
        return () -> {
            RvObjectCriteria rvObjectCriteria = new RvObjectCriteria();
            rvObjectCriteria.or().andObjPkIsNotNull();
            return rvObjectService.get(rvObjectCriteria);
        };
    }

    @RequestMapping("getFlw")
    public @ResponseBody
    Callable<List<RvFlow>> getRvFlowsByObj(String oid,int page,int row){
        if(oid == null || oid.equals("")) return null;
        return () -> {
            RvFlowCriteria flowCriteria = new RvFlowCriteria();
            flowCriteria.or().andObjEqualTo(oid);
            return rvFlowService.get(flowCriteria,page,row);
        };
    }

    @RequestMapping("afTail")
    public @ResponseBody
    String addRvFlowToEnd(String obj,String pre,String atm){
        if(obj == null || obj.equals("")) return "error";
        RvFlow rvFlow = new RvFlow();
        rvFlow.setPk(UUID.randomUUID().toString().substring(0,8));
        rvFlow.setPre(pre);
        rvFlow.setAtm(atm);
        rvFlow.setObj(obj);
        return Integer.toString(rvFlowService.insert(rvFlow,TAIL));
    }

    @RequestMapping("afHead")
    public @ResponseBody
    String addRvFlowToHead(String obj,String suc,String atm){
        if(obj == null || obj.equals("")) return "error";
        RvFlow rvFlow = new RvFlow();
        rvFlow.setPk(UUID.randomUUID().toString().substring(0,8));
        rvFlow.setAtm(atm);
        rvFlow.setObj(obj);
        rvFlow.setSuc(suc);
        return Integer.toString(rvFlowService.insert(rvFlow,HEAD));
    }
    @RequestMapping("afMid")
    public @ResponseBody
    String addRvFlowToMid(String obj,String pre,String suc,String atm){
        if(obj == null || obj.equals("")) return "error";
        RvFlow rvFlow = new RvFlow();
        rvFlow.setPk(UUID.randomUUID().toString().substring(0,8));
        rvFlow.setObj(obj);
        rvFlow.setAtm(atm);
        rvFlow.setPre(pre);
        rvFlow.setSuc(suc);
        return Integer.toString(rvFlowService.insert(rvFlow,MID));
    }
    @RequestMapping("afSig")
    public @ResponseBody
    String addRvFlowSig(String obj,String atm){
        if(obj == null || obj.equals("")) return "error";
        RvFlow rvFlow = new RvFlow();
        rvFlow.setPk(UUID.randomUUID().toString().substring(0,8));
        return null;
    }

    @RequestMapping("delFlw")
    public @ResponseBody
    String deleteRvFlow(String pk) throws Exception {
        return Integer.toString(rvFlowService.delete(pk));
    }

    @RequestMapping(value = "getAtms")
    public @ResponseBody
    Callable<List<AtmView>> getAllAtm(Integer page,Integer row){
        return () -> {
            if(page == null || row == null) return null;
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andPkIsNotNull();
            List<AtmTran> atmTranList = atmTranService.get(atmTranCriteria,page,row);
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

    @RequestMapping("countAtm")
    public @ResponseBody
    Callable<Long> countAtmTrans(){
        return () -> {
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andPkIsNotNull();
            return atmTranService.countAtms(atmTranCriteria) ;
        };
    }

    @RequestMapping("getAtmByDpm")
    public @ResponseBody
    Callable<List<AtmTran>> getAtmByDepartment(String department,int page,int row){
        return () -> {
            if(department == null || department.equals("")) return null;
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andRvDpEqualTo(department);
            return atmTranService.get(atmTranCriteria,page,row);
        };
    }

    @RequestMapping("getAtmByOfc")
    public @ResponseBody
    Callable<List<AtmTran>> getAtmByOffice(String department,int position,int page,int row){
        return () -> {
            if(department == null || department.equals("")) return null;
            AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
            atmTranCriteria.or().andRvDpEqualTo(department).andRvPosiEqualTo((byte) position);
            return atmTranService.get(atmTranCriteria,page,row);
        };
    }

    @RequestMapping("addAtm")
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

    @RequestMapping("updAtm")
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

    @RequestMapping("delAtm")
    public @ResponseBody
    String deleteAtm(@RequestBody Map request) throws Exception {
        String pk = (String) request.get("pk");
        if(pk == null || pk.equals("")) return "error";
        return Integer.toString(atmTranService.delete(pk));
    }
}
