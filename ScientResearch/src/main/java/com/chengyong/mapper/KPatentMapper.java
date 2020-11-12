package com.chengyong.mapper;

import com.chengyong.entity.KPatent;

import java.util.List;

public interface KPatentMapper {
    int deleteByPrimaryKey(Short zid);

    int insert(KPatent record);

    int insertSelective(KPatent record);

    KPatent selectByPrimaryKey(Short zid);

    String selectByPATH(Short zid);

    Short selectByzachnum(Short zid);

    int updateByPrimaryKeySelective(KPatent record);

    int updateByPrimaryKey(KPatent record);

    int updateByPrimaryKey1(KPatent record);

    List<KPatent> patentlist3(KPatent record);

    List<KPatent> patentlist2(KPatent record);

    List<KPatent> patentlist1(KPatent record);

    int updateByZACHNUM2(Short zid,Short zachnum);

    int updateByZACHNUM1(Short zid,Short zachnum);

    Integer countKPATENT(KPatent record);

    Integer countKPATENTdept(KPatent record);

    Integer countKPATENTsch(KPatent record);
}