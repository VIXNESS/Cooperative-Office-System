package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Student;
import com.jiangtao.cos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("stu")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("get")
    public Student stuGet(){
        Student student = studentService.getStudentById(1);
        return student;
    }


}
