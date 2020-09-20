package com.chengyong.mapper;

import com.chengyong.entity.KDept;

public interface KDeptMapper {
    int deleteByPrimaryKey(Short did);

    int insert(KDept record);

    int insertSelective(KDept record);

    KDept selectByPrimaryKey(Short did);

    int updateByPrimaryKeySelective(KDept record);

    int updateByPrimaryKey(KDept record);
}