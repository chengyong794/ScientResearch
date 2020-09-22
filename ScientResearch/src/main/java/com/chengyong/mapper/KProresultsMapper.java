package com.chengyong.mapper;

import com.chengyong.entity.KProresults;

public interface KProresultsMapper {
    int deleteByPrimaryKey(Short prid);

    int insert(KProresults record);

    int insertSelective(KProresults record);

    KProresults selectByPrimaryKey(Short prid);

    int updateByPrimaryKeySelective(KProresults record);

    int updateByPrimaryKey(KProresults record);
}