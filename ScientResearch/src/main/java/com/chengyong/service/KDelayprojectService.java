package com.chengyong.service;

import com.chengyong.entity.KDelayproject;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KDelayprojectService {
    int deleteByPrimaryKey(Short pdelayid);

    int insert(KDelayproject record);

    int insertSelective(KDelayproject record);

    KDelayproject selectByPrimaryKey(Short pdelayid);

    String selectDelaypath(Short pdelayid);

    DataJson delaylistProject1(KDelayproject record);

    DataJson delaylistProject2(KDelayproject record);

    int updateByPYQ1(Short pyq1,Short pdelayid,Short pid);

    int updateByPYQ2(Short pyq2,Short pdelayid,Short pid);

    int updateByPrimaryKeySelective(KDelayproject record);

    int updateByPrimaryKey(KDelayproject record);
}
