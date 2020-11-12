package com.chengyong.mapper;

import com.chengyong.entity.KProresults;

import java.util.List;

public interface KProresultsMapper {
    int deleteByPrimaryKey(Short prid);

    int insert(KProresults record);

    int insertSelective(KProresults record);

    KProresults selectByPrimaryKey(Short prid);

    int updateByPrimaryKeySelective(KProresults record);

    int updateByPrimaryKey(KProresults record);

    int updateByPrimaryKey1(KProresults record);

    List<KProresults> KProresultlist3(KProresults record);

    List<KProresults> KProresultlist2(KProresults record);

    List<KProresults> KProresultlist1(KProresults record);

    int updateByPRACHNUM2(Short prid,Short prachnum);

    int updateByPRACHNUM1(Short prid,Short prachnum);

    Short selectByPRACHNUM(Short prid);

    String selectByPATH(Short prid);

    Integer countKPRORESULTS(KProresults record);

    Integer countKPRORESULTSdept(KProresults record);

    Integer countKPRORESULTSsch(KProresults record);
}