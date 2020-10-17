package com.chengyong.mapper;

import com.chengyong.entity.KPici;

import java.util.List;

public interface KPiciMapper {
    int deleteByPrimaryKey(Short pcid);

    int insert(KPici record);

    int insertSelective(KPici record);

    KPici selectByPrimaryKey(Short pcid);

    int updateByPrimaryKeySelective(KPici record);

    int updateByPrimaryKey(KPici record);

    List<KPici> listdeclare(KPici record);
}