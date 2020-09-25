package com.chengyong.mapper;

import com.chengyong.entity.KView;
import com.chengyong.entity.Ktreenode;

import java.util.List;

public interface KViewMapper {
    int deleteByPrimaryKey(Short viewid);

    int insert(KView record);

    int insertSelective(KView record);

    KView selectByPrimaryKey(Short viewid);

    int updateByPrimaryKeySelective(KView record);

    int updateByPrimaryKey(KView record);

    KView findById(Short viewId);

    List<Ktreenode> selectKview();

    List<KView> findByIdList(Short viewId);
}