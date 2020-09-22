package com.chengyong.mapper;

import com.chengyong.entity.KKyrole;

public interface KKyroleMapper {
    int deleteByPrimaryKey(Short rId);

    int insert(KKyrole record);

    int insertSelective(KKyrole record);

    KKyrole selectByPrimaryKey(Short rId);

    int updateByPrimaryKeySelective(KKyrole record);

    int updateByPrimaryKey(KKyrole record);
}