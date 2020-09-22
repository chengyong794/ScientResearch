package com.chengyong.mapper;

import com.chengyong.entity.KThesis;

public interface KThesisMapper {
    int deleteByPrimaryKey(Short tid);

    int insert(KThesis record);

    int insertSelective(KThesis record);

    KThesis selectByPrimaryKey(Short tid);

    int updateByPrimaryKeySelective(KThesis record);

    int updateByPrimaryKey(KThesis record);
}