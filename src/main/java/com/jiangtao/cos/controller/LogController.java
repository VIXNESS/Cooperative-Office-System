package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;
    public List<Log> getLogsByStaff(){
        
        return null;
    }

    public List<Log> getLogsByData(){
        //todo
        return null;
    }

    public List<Log> getLogsByCategory(){
        //todo
        return null;
    }

    public List<Log> getLogsByTargetTable(){
        //todo
        return null;
    }
}
