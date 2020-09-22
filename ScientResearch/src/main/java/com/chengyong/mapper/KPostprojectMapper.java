package com.chengyong.mapper;

import com.chengyong.entity.KPostproject;

public interface KPostprojectMapper {
    int deleteByPrimaryKey(Short ppid);

    int insert(KPostproject record);

    int insertSelective(KPostproject record);

    KPostproject selectByPrimaryKey(Short ppid);

    int updateByPrimaryKeySelective(KPostproject record);

    int updateByPrimaryKey(KPostproject record);
}