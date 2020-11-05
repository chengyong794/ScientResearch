package com.chengyong.service;

import com.chengyong.entity.KPostproject;
import com.chengyong.util.DataJson;


public interface KPostprojectService {
    DataJson K_POSTPROJECTlist1(KPostproject kPostproject);

    int updateByPPSTATE1(Short ppid,Short ppstate1,Short pid);

    int updateByPPSTATE2(Short ppid,Short ppstate2,Short pid);

    int deleteByPrimaryKey(Short ppid);

    int insert(KPostproject record);

    int insertSelective(KPostproject record);

    KPostproject selectByPrimaryKey(Short ppid);

    int updateByPrimaryKeySelective(KPostproject record);

    int updateByPrimaryKey(KPostproject record);

}
