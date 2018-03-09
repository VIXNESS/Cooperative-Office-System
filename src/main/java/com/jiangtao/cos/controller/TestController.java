package com.jiangtao.cos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("foo")
    public @ResponseBody
    String test(Byte a){
        if(a == null) return "-1";
        return Integer.toString(a);
    }
}
