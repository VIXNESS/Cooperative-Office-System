package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;
import com.jiangtao.cos.pojo.LogView;
import com.jiangtao.cos.service.LogService;
import com.jiangtao.cos.service.LogViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("logger")
public class LogController {
    private final LogService logService;
    private final LogViewService logViewService;

    @Autowired
    public LogController(LogService logService, LogViewService logViewService) {
        this.logService = logService;
        this.logViewService = logViewService;
    }

    @GetMapping("getLogByUser")
    @ResponseBody
    public Callable<List<Log>> getLogsByStaff(String uid) throws Exception {
        return () -> {
            LogCriteria logCriteria = new LogCriteria();
            logCriteria.or().andStaffIdEqualTo(uid);
            List<Log> logList =  logService.get(logCriteria);
            return logList;
        };
    }

    @GetMapping("reviewed")
    @ResponseBody
    public Callable<List<LogView>> getLogReviewedLogs(String uid){
        return () -> logViewService.selectByStaffId(uid);
    }
}
