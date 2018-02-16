package com.jiangtao.cos.service;

import com.jiangtao.cos.dao.StudentMapper;
import com.jiangtao.cos.pojo.Student;
import com.jiangtao.cos.pojo.StudentCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudentById(int id) {
        StudentCriteria studentCriteria = new StudentCriteria();
        studentCriteria.createCriteria().andSIdEqualTo(id);
        return studentMapper.selectByExample(studentCriteria).get(0);
    }
}
