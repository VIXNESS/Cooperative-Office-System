package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;
import com.jiangtao.cos.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;
    public Callable<List<Log>> getLogsByStaff(HttpSession httpSession, int page, int row){
        String uid = (String) httpSession.getAttribute("currentUser");
        if(uid == null || uid.equals("")) return null;
        LogCriteria logCriteria = new LogCriteria();
        logCriteria.or().andStaffIdEqualTo(uid);
        return new Callable<List<Log>>() {
            @Override
            public List<Log> call() throws Exception {
                return logService.get(logCriteria,page,row);
            }
        };
    }

    public Callable<List<Log>> getLogsByDate(String date,int page,int row) throws ParseException {
        LogCriteria logCriteria = new LogCriteria();
        logCriteria.or().andLogDateEqualTo(new SimpleDateFormat("yyyy-mm-dd").parse(date));
        return new Callable<List<Log>>() {
            @Override
            public List<Log> call() throws Exception {
                return logService.get(logCriteria,page,row);
            }
        };
    }

    public Callable<List<Log>> getLogsByCategory(int category,int page,int row){
        return new Callable<List<Log>>() {
            @Override
            public List<Log> call() throws Exception {
                LogCriteria logCriteria = new LogCriteria();
                logCriteria.or().andCategoryEqualTo((byte)category);
                return logService.get(logCriteria,page,row);
            }
        };
    }

    public Callable<List<Log>> getLogsByTargetTable(String tb,int page,int row){
        return new Callable<List<Log>>() {
            @Override
            public List<Log> call() throws Exception {
                LogCriteria logCriteria = new LogCriteria();
                logCriteria.or().andTgTableEqualTo(tb);
                return logService.get(logCriteria,page,row);
            }
        };
    }
}
