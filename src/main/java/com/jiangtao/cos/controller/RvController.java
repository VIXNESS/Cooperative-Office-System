package com.jiangtao.cos.controller;

import com.jiangtao.cos.dao.RvFlowMapper;
import com.jiangtao.cos.pojo.RvFlowKey;
import com.jiangtao.cos.service.RvFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("rvf")
public class RvController {
    @Autowired
    private RvFlowService rvFlowService;

    public Callable<List<RvFlowKey>> getRfByObj(){
        //todo
        return null;
    }

    public String addRvFlow(){
        //todo
        return null;
    }

    public String updateRvFlowSerial(){
        //todo
        return null;
    }

    public String deleteRvFlow(){
        //todo
        return null;
    }
}
