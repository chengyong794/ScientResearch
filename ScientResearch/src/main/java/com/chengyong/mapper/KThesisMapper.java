package com.chengyong.mapper;

import com.chengyong.entity.KThesis;

import java.util.List;

public interface KThesisMapper {
    int deleteByPrimaryKey(Short tid);

    int insert(KThesis record);

    int insertSelective(KThesis record);

    KThesis selectByPrimaryKey(Short tid);

    List<KThesis> thesislistResult3(KThesis record);

    List<KThesis> thesislistResult2(KThesis record);

    List<KThesis> thesislistResult1(KThesis record);

    int updateByPrimaryKeySelective(KThesis record);

    int updateByPrimaryKey(KThesis record);

    int updateByPrimaryKey1(KThesis record);

    int updateBytachnum2(Short tid,Short tachnum);

    int updateBytachnum1(Short tid,Short tachnum);

    String selectBypath(Short tid);

    Short selectBytachnum(Short tid);
}