package com.chengyong.mapper;

import com.chengyong.entity.KUnit;

public interface KUnitMapper {
    int deleteByPrimaryKey(Short uid);

    int insert(KUnit record);

    int insertSelective(KUnit record);

    KUnit selectByPrimaryKey(Short uid);

    int updateByPrimaryKeySelective(KUnit record);

    int updateByPrimaryKey(KUnit record);
}