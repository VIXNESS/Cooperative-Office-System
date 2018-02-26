package com.jiangtao.cos.controller;

import com.jiangtao.cos.service.StaffService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("staff")
public class StaffController {
    private StaffService staffService;
    @RequestMapping("add")
    public String addStaff(){
        return "true";
    }
}
