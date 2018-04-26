package com.jiangtao.cos.controller;

import com.jiangtao.cos.pojo.*;
import com.jiangtao.cos.service.*;
import com.jiangtao.cos.utils.StorageFileNotFoundException;
import com.jiangtao.cos.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("app")
public class ApplicationController {

    private final ApplicationService applicationService;

    private final RvFlowService rvFlowService;

    private final StorageService storageService;

    private final ApplicationViewService applicationViewService;

    private final LogService logService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, RvFlowService rvFlowService, StorageService storageService, ApplicationViewService applicationViewService, LogService logService) {
        this.applicationService = applicationService;
        this.rvFlowService = rvFlowService;
        this.storageService = storageService;
        this.applicationViewService = applicationViewService;
        this.logService = logService;
    }

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
            applicationCriteria.or().andApActorEqualTo(apActor);
            if(row == 0){
                return applicationService.get(applicationCriteria);
            }else {
                return applicationService.get(applicationCriteria,page,row);
            }
        };
    }

    @GetMapping("getByViewer")
    public @ResponseBody
    Callable<List<ApplicationView>> getApplicationByReviewer(String reviewerPk){
        return () -> applicationViewService.selectApplicationViewByViewerPk(reviewerPk);
    }

    @PostMapping("addToFlow")
    public @ResponseBody
    ResponseEntity<?> addToRvFlow(@RequestBody Map request){
        String ptr = (String) request.get("ptr");
        String comment = (String) request.get("comment");
        String rvPk = (String) request.get("rvPk");
        String actor = (String) request.get("actor");
        String pk = UUID.randomUUID().toString();
        try{
            Application application = new Application();
            application.setApPk(pk);
            application.setPtr(ptr);
            application.setApComment(comment);
            application.setRvPk(rvPk);
            application.setApActor(actor);
            application.setApDate(new Date());
            applicationService.insert(application);

            Log log = new Log(actor,new Date(),pk,LogInf.APPLICATION,LogInf.SUBMIT);
            logService.insert(log);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();

    }

    @PostMapping("draftToFlow")
    public @ResponseBody
    ResponseEntity<?> draftToFlow(@RequestBody Map request){
        String pk = (String) request.get("pk");
        String comment = (String) request.get("comment");
        String ptr = (String) request.get("ptr");

        try {
            Application application =  applicationService.getByPk(pk);
            application.setApComment(comment);
            application.setPtr(ptr);
            application.setApDate(new Date());
            applicationService.update(application);

            Log log = new Log(application.getApActor(),new Date(),pk,LogInf.APPLICATION,LogInf.SUBMIT);
            logService.insert(log);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("addAsDraft")
    public @ResponseBody
    ResponseEntity<?> addApplication(@RequestBody Map request){
            String rv = (String) request.get("rvPk");
            String comment = (String) request.get("comment");
            String uid = (String) request.get("actor");

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
                Log log = new Log(uid,new Date(),uniqueID,LogInf.APPLICATION,LogInf.SUBMIT);
                logService.insert(log);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
        return ResponseEntity.ok().build();

    }

    @PostMapping("updateComment")
    public @ResponseBody
    String updateComment(@RequestBody Map request) throws Exception {
        String ap = (String) request.get("appPk");
        String comment = (String) request.get("comment");
        Application application = applicationService.getByPk(ap);
        application.setApComment(comment);
        Log log = new Log(application.getApActor(),new Date(),ap,LogInf.APPLICATION,LogInf.UPDATE);
        logService.insert(log);
        return Integer.toString(applicationService.update(application));
    }

    @PostMapping("updatePtr")
    public @ResponseBody
    String updatePtr(String pk,String ptr) throws Exception {
        Application application = applicationService.getByPk(pk);
        application.setApPk(pk);
        application.setPtr(ptr);
        Log log = new Log(application.getApActor(),new Date(),pk,LogInf.APPLICATION,LogInf.UPDATE);
        logService.insert(log);
        return Integer.toString(applicationService.update(application));
    }

    @PostMapping("toDraft")
    public @ResponseBody
    ResponseEntity<?> toDraft(@RequestBody Map request){
        String apPk = (String) request.get("apPk");
        String apCommnet = (String) request.get("apCommnet");
        try{
            Application application = applicationService.getByPk(apPk);
            application.setPtr(null);
            application.setApComment(apCommnet);
            applicationService.update(application);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("del")
    public @ResponseBody
    Callable<String> deleteApplication(@RequestBody Map request) throws Exception {
        String pk = (String) request.get("pk");
        Log log = new Log(applicationService.getByPk(pk).getApActor(),new Date(), pk,LogInf.APPLICATION,LogInf.DELETE);
        logService.insert(log);
        return () -> Integer.toString(applicationService.delete(pk));
    }

    @PostMapping(value = "pass")
    public @ResponseBody
    ResponseEntity<?> passApp(@RequestBody Map request){
        String apPk = (String) request.get("apPk");
        String comment = (String) request.get("comment");
        String viewer = (String) request.get("viewer");
        try{
            Application application = applicationService.getByPk(apPk);
            RvFlow rvFlow = rvFlowService.getByPk(application.getPtr());
            application.setPtr(rvFlow.getSuc());
            application.setApComment(comment);
            applicationService.update(application);
            Log log = new Log(viewer,new Date(), apPk,LogInf.APPLICATION,LogInf.PASS);
            logService.insert(log);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "reject")
    public @ResponseBody
    ResponseEntity<?> rejectApp(@RequestBody Map request){
        String apPk = (String) request.get("apPk");
        String comment = (String) request.get("comment");
        String viewer = (String) request.get("viewer");
        try{
            Application application = applicationService.getByPk(apPk);
            application.setPtr(null);
            application.setApComment(comment);
            applicationService.update(application);
            Log log = new Log(viewer,new Date(),apPk,LogInf.APPLICATION,LogInf.REJECT);
            logService.insert(log);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        ResponseEntity<Resource> rs =  ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        return rs;
    }


    @PostMapping("/filesUpload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file,String info) {
        storageService.store(file,info);
        return info + file.getName();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
