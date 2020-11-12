package com.chengyong.service;

import com.chengyong.entity.KPatent;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KPatentService {

    int deleteByPrimaryKey(Short zid);

    int deleteByPrimaryKeylow(Short[] zids);

    int insert(KPatent record);

    int insertSelective(KPatent record);

    KPatent selectByPrimaryKey(Short zid);

    String selectByPATH(Short zid);

    int updateByPrimaryKeySelective(KPatent record);

    int updateByPrimaryKey(KPatent record);

    int updateByPrimaryKey1(KPatent record);

    DataJson patentlist3(KPatent record);

    DataJson patentlist2(KPatent record);

    DataJson patentlist1(KPatent record);

    int updateByZACHNUM2(Short zid,Short zachnum);

    int updateByZACHNUM1(Short zid,Short zachnum);

    Integer countKPATENT(String statyear,String endyear);

    Integer countKPATENTdept(String statyear,String endyear);

    Integer countKPATENTsch(String statyear,String endyear);
}
