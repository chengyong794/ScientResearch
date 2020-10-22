package com.chengyong.mapper;

import com.chengyong.entity.KProjectper;

import java.util.List;

public interface KProjectperMapper {
    int deleteByPrimaryKey(Short pperid);

    int insert(KProjectper record);

    int insertSelective(KProjectper record);

    KProjectper selectByPrimaryKey(Short pperid);

    int updateByPrimaryKeySelective(KProjectper record);

    int updateByPrimaryKey(KProjectper record);

    List<String> selectName(Short pid);
}