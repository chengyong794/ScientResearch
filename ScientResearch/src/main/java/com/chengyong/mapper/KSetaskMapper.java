package com.chengyong.mapper;

import com.chengyong.entity.KSetask;

public interface KSetaskMapper {
    int deleteByPrimaryKey(Short tid);

    int insert(KSetask record);

    int insertSelective(KSetask record);

    KSetask selectByPrimaryKey(Short tid);

    int updateByPrimaryKeySelective(KSetask record);

    int updateByPrimaryKey(KSetask record);
}