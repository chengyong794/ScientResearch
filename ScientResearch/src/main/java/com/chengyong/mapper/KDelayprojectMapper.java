package com.chengyong.mapper;

import com.chengyong.entity.KDelayproject;

import java.util.List;

public interface KDelayprojectMapper {
    int deleteByPrimaryKey(Short pdelayid);

    int deleteBypid(Short pid);

    int insert(KDelayproject record);

    int insertSelective(KDelayproject record);

    KDelayproject selectByPrimaryKey(Short pdelayid);

    Short selectByPDELAYID(Short pid);

    String selectDelaypath(Short pdelayid);

    int updateByPYQ1(Short pyq1,Short pdelayid);

    int updateByPYQ2(Short pyq2,Short pdelayid);

    List<KDelayproject> delaylistProject1(KDelayproject record);

    List<KDelayproject> delaylistProject2(KDelayproject record);

    int updateByPrimaryKeySelective(KDelayproject record);

    int updateByPrimaryKey(KDelayproject record);
}