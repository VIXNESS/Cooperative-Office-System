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
    private final StaffService staffService;

    private final OfficeService officeService;

    private final DepartmentService departmentService;

    private final PositionService positionService;

    @Autowired
    public StaffController(StaffService staffService, OfficeService officeService, DepartmentService departmentService, PositionService positionService) {
        this.staffService = staffService;
        this.officeService = officeService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @GetMapping(value = "staffInfo")
    public @ResponseBody
    Callable<Staff> getStaff(String uid) throws Exception {
        return () -> staffService.getByPk(uid);
    }

    @GetMapping(value = "permission")
    public @ResponseBody
    Callable<String> checkPermission(String uid) throws Exception {
        return () -> {
          OfficeCriteria officeCriteria = new OfficeCriteria();
          officeCriteria.or().andStaffEqualTo(uid);
          List<Office> officeList = officeService.get(officeCriteria);
          String flag = "false";
          for(Office office : officeList){
           if(departmentService.getByPk(office.getDepartment()).getPrior() == 1){
               flag = "true";
           }
          }
          return flag;
        };
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
