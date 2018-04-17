package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.RvFlowMapper;
import com.jiangtao.cos.pojo.RvFlow;
import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RvFlowServiceImp implements RvFlowService {
    @Autowired
    RvFlowMapper rvFlowMapper;

    @Override
    public List<RvFlow> get(RvFlowCriteria rvFlowCriteria) throws Exception {
        return rvFlowMapper.selectByExample(rvFlowCriteria);
    }

    @Override
    public List<RvFlow> get(RvFlowCriteria rvFlowCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return rvFlowMapper.selectByExample(rvFlowCriteria);
    }

    @Override
    public RvFlow getByPk(String pk){
        return rvFlowMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(RvFlow rvFlow,String position){
        if(position.equals(SIG)){
            return rvFlowMapper.insert(rvFlow);
        }

        if(position.equals(HEAD)){// insert to head
            RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
            rvFlowCriteria.or().andObjEqualTo(rvFlow.getObj()).andPreIsNull();
            RvFlow temp = rvFlowMapper.selectByExample(rvFlowCriteria).get(0);
            temp.setPre(rvFlow.getPk());
            rvFlow.setSuc(temp.getPk());
            rvFlowMapper.updateByPrimaryKey(temp);
            return rvFlowMapper.insert(rvFlow);
        }

        if(position.equals((TAIL))){// insert to tailor
            RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
            rvFlowCriteria.or().andObjEqualTo(rvFlow.getObj()).andSucIsNull();
            RvFlow temp = rvFlowMapper.selectByExample(rvFlowCriteria).get(0);
            temp.setSuc(rvFlow.getPk());
            rvFlow.setPre(temp.getPk());
            rvFlowMapper.updateByPrimaryKey(temp);
            return rvFlowMapper.insert(rvFlow);
        }

        if(position.equals(MID)){// insert to middle
            RvFlow pre = rvFlowMapper.selectByPrimaryKey(rvFlow.getPre());
            RvFlow suc = rvFlowMapper.selectByPrimaryKey(rvFlow.getSuc());
            rvFlow.setPre(pre.getPk());
            rvFlow.setSuc(suc.getPk());
            pre.setSuc(rvFlow.getPk());
            suc.setPre(rvFlow.getPk());
            rvFlowMapper.updateByPrimaryKey(pre);
            rvFlowMapper.updateByPrimaryKey(suc);
            return rvFlowMapper.insert(rvFlow);
        }
        return -1;
    }

    @Override
    public int delete(String pk) throws Exception {
        RvFlow rvFlow = getByPk(pk);
        if(rvFlow.getPre() == null && rvFlow.getSuc() == null){
            rvFlowMapper.deleteByPrimaryKey(rvFlow.getPk());
        }
        if(rvFlow.getPre() != null){
            RvFlow temp = rvFlowMapper.selectByPrimaryKey(rvFlow.getPre());
            temp.setSuc(rvFlow.getSuc());
            rvFlowMapper.updateByPrimaryKey(temp);
        }
        if(rvFlow.getSuc() != null){
            RvFlow temp = rvFlowMapper.selectByPrimaryKey(rvFlow.getSuc());
            temp.setPre(rvFlow.getPre());
            rvFlowMapper.updateByPrimaryKey(temp);
        }
        return rvFlowMapper.deleteByPrimaryKey(rvFlow.getPk());
    }

    @Override
    public int delete(RvFlowCriteria rvFlowCriteria) {
        return rvFlowMapper.deleteByExample(rvFlowCriteria);
    }

    @Override
    public int update(RvFlow rvFlow){
        return rvFlowMapper.updateByPrimaryKey(rvFlow);
    }

    @Override
    public int add(RvFlow rvFlow) throws Exception {
        return rvFlowMapper.insert(rvFlow);
    }
}
