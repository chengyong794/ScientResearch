package com.chengyong.service;

import com.chengyong.entity.KProresults;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KProresultsService {

    int deleteByPrimaryKey(Short prid);

    int deleteByPrimaryKeylow(Short[] prids);

    int insert(KProresults record);

    int insertSelective(KProresults record);

    KProresults selectByPrimaryKey(Short prid);

    int updateByPrimaryKeySelective(KProresults record);

    int updateByPrimaryKey(KProresults record);

    DataJson KProresultlist3(KProresults record);

    DataJson KProresultlist2(KProresults record);

    DataJson KProresultlist1(KProresults record);

    int updateByPRACHNUM2(Short prid,Short prachnum);

    int updateByPRACHNUM1(Short prid,Short prachnum);

    String selectByPATH(Short prid);

    Integer countKPRORESULTS(String statyear,String endyear);

    Integer countKPRORESULTSdept(String statyear,String endyear);

    Integer countKPRORESULTSsch(String statyear,String endyear);

    Integer therecountKprojectresult(String statyear);

    Integer therecountKprojectresult2(String statyear);

    Integer therecountKprojectresult1(String statyear);

    Integer deptcountKprojectresult(String statyear,String dept);
}
