package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Staff;

public interface StaffService {
    boolean addStaff(Staff staff);
    Staff findStaffById(String id);
}
