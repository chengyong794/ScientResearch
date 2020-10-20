package com.chengyong.mapper;

import com.chengyong.entity.KProject;

public interface KProjectMapper {
    int deleteByPrimaryKey(Short pid);

    int insert(KProject record);

    int insertSelective(KProject record);

    KProject selectByPrimaryKey(Short pid);

    int updateByPrimaryKeySelective(KProject record);

    int updateByPrimaryKey(KProject record);

    KProject selectByPnameAndPPEOPLE(KProject kProject);
}