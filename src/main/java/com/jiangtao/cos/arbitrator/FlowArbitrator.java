package com.jiangtao.cos.arbitrator;


import com.jiangtao.cos.pojo.Application;

public interface FlowArbitrator {
    /**
     *
     * @param application
     * @return Ptr primary key
     */
    String selectFlow(Application application);
}
