package com.chengyong.mapper;

import com.chengyong.entity.KWork;

import java.util.List;

public interface KWorkMapper {
    int deleteByPrimaryKey(Short wid);

    int insert(KWork record);

    int insertSelective(KWork record);

    KWork selectByPrimaryKey(Short wid);

    int updateByPrimaryKeySelective(KWork record);

    int updateByPrimaryKey(KWork record);

    int updateByPrimaryKey1(KWork record);

    List<KWork> booklistResult3(KWork record);

    List<KWork> booklistResult2(KWork record);

    List<KWork> booklistResult1(KWork record);

    int updateByWACHNUM1(Short wid,Short wachnum);

    int updateByWACHNUM2(Short wid,Short wachnum);

    String selectByPath(Short wid);

    Short selectBywachnum(Short wid);

    Integer countKWork(KWork record);

    Integer countKWorkdept(KWork record);

    Integer countKWorksch(KWork record);

    Integer therecountKWork(KWork record);

    Integer therecountKWork2(KWork record);

    Integer therecountKWork1(KWork record);

    Integer deptcountKWork(KWork record);
}