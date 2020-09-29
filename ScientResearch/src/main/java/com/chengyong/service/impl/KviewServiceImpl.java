package com.chengyong.service.impl;

import com.chengyong.entity.Ktreenode;
import com.chengyong.entity.KView;
import com.chengyong.mapper.KViewMapper;
import com.chengyong.mapper.KtreenodeMapper;
import com.chengyong.service.KviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KviewServiceImpl implements KviewService {
    @Autowired
    private KViewMapper kviewMapper;

    @Autowired
    private KtreenodeMapper ktreenodeMapper;

    @Override
    public int deleteByPrimaryKey(Short viewid) {
        return 0;
    }

    @Override
    public int insert(KView record) {
        return 0;
    }

    @Override
    public int insertSelective(KView record) {
        return 0;
    }

    @Override
    public KView selectByPrimaryKey(Short viewid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KView record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KView record) {
        return 0;
    }

    @Override
    @Cacheable("findById")
    public KView findById(Short viewId) {
        return kviewMapper.findById(viewId);
    }

    @Cacheable("selectKview")
    @Override
    public List<KView> selectKview() {
        //查询 menuInfo
        KView kview = kviewMapper.findById((short)3);
        //查询
        List<Ktreenode> ktreenodeList = ktreenodeMapper.listTreeNode();

        List<Ktreenode> ktreenodeList1 = new ArrayList<>();
        for (Ktreenode k1:
             ktreenodeList) {
            if(k1.getType()==1){  //等于1 说明是根节点
               ktreenodeList1.add(k1);
            }
            for (Ktreenode k2:
                    ktreenodeList) {
                if(k2.getParentid()==k1.getTreenodeid()){ //相等 ，是子节点
                    k1.getChild().add(k2); //将子节点添加到 根节点
                }
            }
        }

        kview.setChild(ktreenodeList1);

        List<KView> kViewList = new ArrayList<>();
        kViewList.add(kview);

        return kViewList;
    }
}
