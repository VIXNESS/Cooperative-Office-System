package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.*;
import com.jiangtao.cos.utils.StorageFileNotFoundException;
import com.jiangtao.cos.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("app")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private RvFlowService rvFlowService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ApplicationViewService applicationViewService;

    @GetMapping("getByPk")
    public @ResponseBody
    Callable<Application> getApplicationByPk(String appPk){
        return () -> applicationService.getByPk(appPk);
    }

    @GetMapping( "getByUsr")
    public @ResponseBody
    Callable<List<Application>> getApplicationsByUser(String apActor,int page,int row){
        return () -> {
            ApplicationCriteria applicationCriteria = new ApplicationCriteria();
            applicationCriteria.or()
                    .andApActorEqualTo(apActor);
            return applicationService.get(applicationCriteria,page,row);
        };
    }

    @GetMapping("getByViewer")
    public @ResponseBody
    Callable<List<ApplicationView>> getApplicationByReviewer(String reviewerPk){
        return () -> applicationViewService.selectApplicationViewByViewerPk(reviewerPk);
    }

    @PostMapping("add")
    public @ResponseBody
    Callable<String> addApplication(@RequestBody Map request){
        return () -> {
            String rv = (String) request.get("pk");
            String comment = (String) request.get("comment");
            String uid = (String) request.get("uid");

            String uniqueID = UUID.randomUUID().toString();
            Application application = new Application();
            application.setApPk(uniqueID);
            application.setRvPk(rv);
            application.setApActor(uid);
            application.setApComment(comment);
            application.setApDate(new Date());
            application.setPtr("");
            try {
                applicationService.insert(application);
            } catch (Exception e) {
                e.printStackTrace();
                return "false";
            }
            return "true";
        };
    }

    @PostMapping("updateComment")
    public @ResponseBody
    Callable<String> updateComment(@RequestBody Map request){
        return () -> {
            String ap = (String) request.get("appPk");
            String comment = (String) request.get("comment");
            Application application = new Application();
            application.setApComment(comment);
            application.setApPk(ap);
            return Integer.toString(applicationService.update(application));
        };
    }

    @PostMapping("updatePtr")
    public @ResponseBody
    Callable<String> updatePtr(String pk,String ptr){
        return () -> {
            Application application = new Application();
            application.setApPk(pk);
            application.setPtr(ptr);
            return Integer.toString(applicationService.update(application));
        };
    }

    @PostMapping("addToFlow")
    public @ResponseBody
    String addToRvFlow(@RequestBody Map request){
        //TODO
        return null;

    }

    @PostMapping("del")
    public @ResponseBody
    Callable<String> deleteApplication(@RequestBody Map request){
        String pk = (String) request.get("pk");
        return () -> Integer.toString(applicationService.delete(pk));
    }

    @PostMapping(value = "nextPtr")
    public @ResponseBody
    String passApp(@RequestBody Map request) throws Exception {
        String apPk = (String) request.get("apPk");
        Application application = applicationService.getByPk(apPk);
        if(application == null) return "null_app";
        if(application.getPtr() == null || application.getPtr().equals("")) return "null_ptr";
        if(application.getRvPk() == null || application.getRvPk().equals("")) return "null_obj";
        RvFlow rvFlow = rvFlowService.getByPk(application.getPtr());
        if(rvFlow.getSuc() == null || rvFlow.getSuc().equals("")) return "finished";
        application.setPtr(rvFlow.getSuc());
        return Integer.toString(applicationService.update(application));
    }


    @GetMapping("files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/filesUpload")
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        storageService.store(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
