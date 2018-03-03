package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("app")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("test")
    public @ResponseBody
    Callable<Application> test(String id){

        return new Callable<Application>() {
            @Override
            public Application call() throws Exception {
                System.out.println(id);
                Application application = new Application();
                application.setApPk(id);
                return application;
            }
        };
    }
}
