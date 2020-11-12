package com.chengyong.service;

import com.chengyong.entity.KThesis;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KThesisService {

    int deleteByPrimaryKey(Short tid);

    int deleteByPrimaryKeylow(Short[] tids);

    int insert(KThesis record);

    int insertSelective(KThesis record);

    KThesis selectByPrimaryKey(Short tid);

    DataJson thesislistResult3(KThesis record);

    DataJson thesislistResult2(KThesis record);

    DataJson thesislistResult1(KThesis record);

    int updateByPrimaryKeySelective(KThesis record);

    int updateByPrimaryKey(KThesis record);

    int updateBytachnum2(Short tid,Short tachnum);

    int updateBytachnum1(Short tid,Short tachnum);

    String selectBypath(Short tid);

    Integer countKTHESIS(String statyear,String endyear);

    Integer countKTHESISdept(String statyear,String endyear);

    Integer countKTHESISsch(String statyear,String endyear);

}
