package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.DepartmentService;
import com.jiangtao.cos.service.OfficeService;
import com.jiangtao.cos.service.PositionService;
import com.jiangtao.cos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.*;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("staff")
//@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "staffInfo",method = RequestMethod.POST)
    public @ResponseBody
    List<Staff> getStaff() throws Exception {
        StaffCriteria staffCriteria = new StaffCriteria();
        staffCriteria.or().andBirthdayIsNotNull();
        return staffService.get(staffCriteria,1,1);
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public @ResponseBody
    Staff login(@RequestBody Map request, HttpSession session)throws Exception{
        String uid = (String) request.get("userid");
        String pwd = (String) request.get("passwd");
        Staff staff = staffService.getByPk(uid);
        if(staff!=null && staff.getPassword().equals(pwd)){
            session.setAttribute("currentUser",staff.getId());
            return staff;
        }else return null;
    }

    @RequestMapping(value = "getOfficeView")
    public @ResponseBody
    Callable<List<OfficeInfoView>> getAllOfficeViews(){
        return () -> {
            OfficeCriteria officeCriteria = new OfficeCriteria();
            officeCriteria.or().andExpiredDateGreaterThan(new Date());
            List<Office> officeList = officeService.get(officeCriteria);
            DepartmentCriteria departmentCriteria = new DepartmentCriteria();
            departmentCriteria.or().andAddrIsNotNull();
            List<Department> departmentList = departmentService.get(departmentCriteria);
            PositionCriteria positionCriteria = new PositionCriteria();
            positionCriteria.or().andPosiNameIsNotNull();
            List<Position> positionList = positionService.get(positionCriteria);
            List<OfficeInfoView> officeInfoViewList = new ArrayList<>();
            for(Office office: officeList){
                Boolean hit = false;
                for(OfficeInfoView infoView: officeInfoViewList){
                    if(office.getDepartment().equals(infoView.getDepartment().getId())){
                        hit = true;
                        Boolean pHit = false;
                        for (Position p: infoView.getPositionList()){
                            if(p.getPosiPk().equals(office.getPosi())){
                                pHit = true;
                                break;
                            }
                        }
                        if(pHit == false){
                            Position temp = null;
                            for(Position p: positionList) {
                                if (p.getPosiPk().equals(office.getPosi())) {
                                    infoView.getPositionList().add(p);
                                    break;
                                }
                            }
                        }
                    }
                    if(hit) break;
                }
                if(hit == false){
                    OfficeInfoView infoViewTemp = new OfficeInfoView();
                    for(Department d: departmentList){
                        if(d.getId().equals(office.getDepartment())){
                            infoViewTemp.setDepartment(d);
                        }
                    }
                    for(Position p: positionList){
                        if(p.getPosiPk().equals(office.getPosi())){
                            infoViewTemp.setPositionList(new ArrayList<>());
                            infoViewTemp.getPositionList().add(p);
                        }
                    }
                    officeInfoViewList.add(infoViewTemp);
                }
            }
            return officeInfoViewList;
        };
    }

}
