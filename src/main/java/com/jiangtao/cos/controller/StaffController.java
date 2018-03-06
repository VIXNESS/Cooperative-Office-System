package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;
import com.jiangtao.cos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @RequestMapping("test")
    public String addStaff(String name, String email, String birthday,String phone,String gender) throws Exception {
        String uniqueID = UUID.randomUUID().toString().substring(0,8);
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
        Staff staff = new Staff();
        staff.setBirthday(date);
        staff.setEmail(email);
        if(gender.equals("female")){
            staff.setGender(new Boolean(false));
        }else {
            staff.setGender(new Boolean(true));
        }
        staff.setId(uniqueID);
        staff.setName(name);
        staff.setPhone(phone);
        staff.setStatus((byte) 0);
        staffService.insert(staff);
        return "{msg:success}";
    }

    @RequestMapping("get")
    public List<Staff> getStaff() throws Exception {
        StaffCriteria staffCriteria = new StaffCriteria();
        staffCriteria.or().andBirthdayIsNotNull();
        return staffService.get(staffCriteria,1,1);
    }
}
