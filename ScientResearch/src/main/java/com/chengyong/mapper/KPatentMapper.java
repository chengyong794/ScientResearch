package com.chengyong.mapper;

import com.chengyong.entity.KPatent;

public interface KPatentMapper {
    int deleteByPrimaryKey(Short zid);

    int insert(KPatent record);

    int insertSelective(KPatent record);

    KPatent selectByPrimaryKey(Short zid);

    int updateByPrimaryKeySelective(KPatent record);

    int updateByPrimaryKey(KPatent record);
}