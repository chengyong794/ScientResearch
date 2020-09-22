package com.chengyong.mapper;

import com.chengyong.entity.KWork;

public interface KWorkMapper {
    int deleteByPrimaryKey(Short wid);

    int insert(KWork record);

    int insertSelective(KWork record);

    KWork selectByPrimaryKey(Short wid);

    int updateByPrimaryKeySelective(KWork record);

    int updateByPrimaryKey(KWork record);
}