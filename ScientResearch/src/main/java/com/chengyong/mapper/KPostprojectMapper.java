package com.chengyong.mapper;

import com.chengyong.entity.KPostproject;

import java.util.List;

public interface KPostprojectMapper {

    List<KPostproject> K_POSTPROJECTlist1(KPostproject kPostproject);

    List<KPostproject> K_POSTPROJECTlist2(KPostproject kPostproject);

    int updateByPPSTATE1(Short ppid,Short ppstate1);

    int updateByPPSTATE2(Short ppid,Short ppstate2);

    int deleteByPrimaryKey(Short ppid);

    int insert(KPostproject record);

    int insertSelective(KPostproject record);

    KPostproject selectByPrimaryKey(Short ppid);

    int updateByPrimaryKeySelective(KPostproject record);

    int updateByPrimaryKey(KPostproject record);
}