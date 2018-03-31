package com.jiangtao.cos.arbitrator;

import com.jiangtao.cos.pojo.Application;
import org.springframework.stereotype.Service;

@Service
public class FlowArbitratorImp implements FlowArbitrator {
    @Override
    public String selectFlow(Application application) {
        return "SUCCESSFUL";
    }
}
