package com.chengyong.mapper;

import com.chengyong.entity.KKyrole;

import java.util.List;

public interface KKyroleMapper {
    int deleteByPrimaryKey(Short rId);

    int insert(KKyrole record);

    int insertSelective(KKyrole record);

    KKyrole selectByPrimaryKey(Short rId);

    int updateByPrimaryKeySelective(KKyrole record);

    int updateByPrimaryKey(KKyrole record);

    List<KKyrole> listRole();
}