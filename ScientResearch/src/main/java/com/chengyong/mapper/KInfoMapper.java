package com.chengyong.mapper;

import com.chengyong.entity.KInfo;

public interface KInfoMapper {
    int deleteByPrimaryKey(Short iid);

    int insert(KInfo record);

    int insertSelective(KInfo record);

    KInfo selectByPrimaryKey(Short iid);

    int updateByPrimaryKeySelective(KInfo record);

    int updateByPrimaryKey(KInfo record);
}