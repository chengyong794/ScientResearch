package com.chengyong.service;

import com.chengyong.entity.KView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KviewService {
    int deleteByPrimaryKey(Short viewid);

    int insert(KView record);

    int insertSelective(KView record);

    KView selectByPrimaryKey(Short viewid);

    int updateByPrimaryKeySelective(KView record);

    int updateByPrimaryKey(KView record);

    KView findById(Short viewId);

    List<KView> selectKview();
}
