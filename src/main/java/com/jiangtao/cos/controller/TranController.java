package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.RvFlowKey;
import com.jiangtao.cos.pojo.RvObject;
import com.jiangtao.cos.service.RvFlowService;
import com.jiangtao.cos.service.RvObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("trn")
public class TranController {
    @Autowired
    private RvFlowService rvFlowService;
    @Autowired
    private RvObjectService rvObjectService;

    public String addRvObj(){
        //todo
        return null;
    }

    public String updateRvObj(){
        //todo
        return null;
    }

    public String deleteRvObj(){
        //todo
        return null;
    }

    public List<RvObject> getRvObjs(){
        //todo
        return null;
    }

    public List<RvFlowKey> getRvFlowsByObj(){
        //todo
        return null;
    }

    public String addRvFlow(){
        //todo
        return null;
    }

    public String updateRvFlow(){
        //todo
        return null;
    }

    public String deleteRvFlow(){
        //todo
        return null;
    }
}
