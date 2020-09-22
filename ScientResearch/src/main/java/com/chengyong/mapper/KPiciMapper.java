package com.chengyong.mapper;

import com.chengyong.entity.KPici;

public interface KPiciMapper {
    int deleteByPrimaryKey(Short pcid);

    int insert(KPici record);

    int insertSelective(KPici record);

    KPici selectByPrimaryKey(Short pcid);

    int updateByPrimaryKeySelective(KPici record);

    int updateByPrimaryKey(KPici record);
}