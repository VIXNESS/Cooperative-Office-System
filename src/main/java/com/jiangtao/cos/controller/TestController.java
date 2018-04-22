package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.pojo.ApplicationView;
import com.jiangtao.cos.service.ApplicationViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("test")
//@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
    @Autowired
    ApplicationViewService applicationViewService;

    @GetMapping("foo")
    public @ResponseBody
    Callable<List<ApplicationView>> test(){
//        System.out.println(request.get("foo"));
        return () -> applicationViewService.selectApplicationViewByViewerPk("00000001");
    }
}
