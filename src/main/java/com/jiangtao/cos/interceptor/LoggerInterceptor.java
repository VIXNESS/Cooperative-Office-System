package com.jiangtao.cos.interceptor;

import com.jiangtao.cos.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Repository
public class LoggerInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private LogService logService;

    private Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("[LoggerInterceptor]:        METHOD: "+request.getMethod());
        super.afterCompletion(request, response, handler, ex);
    }
}
