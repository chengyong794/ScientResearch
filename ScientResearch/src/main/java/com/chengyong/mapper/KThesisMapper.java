package com.chengyong.mapper;

import com.chengyong.entity.KThesis;

import java.util.List;

public interface KThesisMapper {
    int deleteByPrimaryKey(Short tid);

    int insert(KThesis record);

    int insertSelective(KThesis record);

    KThesis selectByPrimaryKey(Short tid);

    List<KThesis> thesislistResult3(KThesis record);

    int updateByPrimaryKeySelective(KThesis record);

    int updateByPrimaryKey(KThesis record);
}