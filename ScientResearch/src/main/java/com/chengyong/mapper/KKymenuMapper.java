package com.chengyong.mapper;

import com.chengyong.entity.KKymenu;

public interface KKymenuMapper {
    int deleteByPrimaryKey(Short mId);

    int insert(KKymenu record);

    int insertSelective(KKymenu record);

    KKymenu selectByPrimaryKey(Short mId);

    int updateByPrimaryKeySelective(KKymenu record);

    int updateByPrimaryKey(KKymenu record);
}