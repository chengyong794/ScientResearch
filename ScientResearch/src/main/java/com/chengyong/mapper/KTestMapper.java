package com.chengyong.mapper;

import com.chengyong.entity.KTest;

public interface KTestMapper {
    int deleteByPrimaryKey(Short tid);

    int insert(KTest record);

    int insertSelective(KTest record);

    KTest selectByPrimaryKey(Short tid);

    int updateByPrimaryKeySelective(KTest record);

    int updateByPrimaryKey(KTest record);
}