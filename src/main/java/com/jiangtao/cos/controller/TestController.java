package com.jiangtao.cos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("test")
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
    @RequestMapping("foo")
    public @ResponseBody
    Callable<String> test(@RequestBody Map request){
        System.out.println(request.get("foo"));
        return () -> "success";
    }
}
