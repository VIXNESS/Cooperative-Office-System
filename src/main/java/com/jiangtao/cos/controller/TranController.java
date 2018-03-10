package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.AtmTranService;
import com.jiangtao.cos.service.RvFlowService;
import com.jiangtao.cos.service.RvObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

import static com.jiangtao.cos.service.RvFlowService.HEAD;
import static com.jiangtao.cos.service.RvFlowService.MID;
import static com.jiangtao.cos.service.RvFlowService.TAIL;

@Controller
@RequestMapping("trn")
public class TranController {

    @Autowired
    private RvFlowService rvFlowService;
    @Autowired
    private RvObjectService rvObjectService;
    @Autowired
    private AtmTranService atmTranService;

    @RequestMapping("addObj")
    public @ResponseBody
    String addRvObj(String name,int type) throws Exception {
        String uniqueID = UUID.randomUUID().toString().substring(0,8);
        RvObject rvObject = new RvObject();
        rvObject.setObjName(name);
        rvObject.setType((byte) type);
        return Integer.toString(rvObjectService.insert(rvObject));
    }


    @RequestMapping("updObj")
    public @ResponseBody
    String updateRvObj(String id,String name) throws Exception {
        if(id == null||id.equals("")) return "null";
        RvObject rvObject = new RvObject();
        if(!(name == null || name.equals(""))) rvObject.setObjName(name);
        rvObject.setObjPk(id);
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
        return new Callable<List<RvObject>>() {
            @Override
            public List<RvObject> call() throws Exception {
                RvObjectCriteria rvObjectCriteria = new RvObjectCriteria();
                rvObjectCriteria.or().andObjPkIsNotNull();
                return rvObjectService.get(rvObjectCriteria);
            }
        };
    }

    @RequestMapping("getFlw")
    public @ResponseBody
    Callable<List<RvFlow>> getRvFlowsByObj(String oid,int page,int row){
        if(oid == null || oid.equals("")) return null;
        return new Callable<List<RvFlow>>() {
            @Override
            public List<RvFlow> call() throws Exception {
                RvFlowCriteria flowCriteria = new RvFlowCriteria();
                flowCriteria.or().andObjEqualTo(oid);
                return rvFlowService.get(flowCriteria,page,row);
            }
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

    @RequestMapping("getAtmByPsi")
    public @ResponseBody
    Callable<List<AtmTran>> getAtm(int position,int page,int row){
        return new Callable<List<AtmTran>>() {
            @Override
            public List<AtmTran> call() throws Exception {
                AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
                atmTranCriteria.or().andRvPosiEqualTo((byte) position);
                return atmTranService.get(atmTranCriteria,page,row);
            }
        };
    }

    @RequestMapping("getAtmByDpm")
    public @ResponseBody
    Callable<List<AtmTran>> getAtmByDepartment(String department,int page,int row){
        return new Callable<List<AtmTran>>() {
            @Override
            public List<AtmTran> call() throws Exception {
                if(department == null || department.equals("")) return null;
                AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
                atmTranCriteria.or().andRvDpEqualTo(department);
                return atmTranService.get(atmTranCriteria,page,row);
            }
        };
    }

    @RequestMapping("getAtmByOfc")
    public @ResponseBody
    Callable<List<AtmTran>> getAtmByDepartment(String department,int position,int page,int row){
        return new Callable<List<AtmTran>>() {
            @Override
            public List<AtmTran> call() throws Exception {
                if(department == null || department.equals("")) return null;
                AtmTranCriteria atmTranCriteria = new AtmTranCriteria();
                atmTranCriteria.or().andRvDpEqualTo(department).andRvPosiEqualTo((byte) position);
                return atmTranService.get(atmTranCriteria,page,row);
            }
        };
    }

    @RequestMapping("addAtm")
    public @ResponseBody
    String addAtm(String department,Byte position,String comment) throws Exception {
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
    String updateAtm(String pk,String comment,String department,Byte position) throws Exception {
        if(pk == null || pk.equals("")) return "error";
        AtmTran atmTran = null;
        if(!(comment == null || comment.equals(""))){
            if(atmTran == null) atmTran = new AtmTran();
            atmTran.setAtmComment(comment);
        }
        if(!(department == null || department.equals(""))){
            if(atmTran == null) atmTran = new AtmTran();
            atmTran.setRvDp(department);
        }
        if(position != null){
            if(atmTran == null) atmTran = new AtmTran();
            atmTran.setRvPosi(position);
        }
        if(atmTran != null){
            atmTran.setPk(pk);
            return Integer.toString(atmTranService.update(atmTran));
        }else {
            return "error";
        }
    }

    @RequestMapping("delAtm")
    public @ResponseBody
    String deleteAtm(String pk) throws Exception {
        if(pk == null || pk.equals("")) return "error";
        return Integer.toString(atmTranService.delete(pk));
    }
}
