package com.chengyong.service;

import com.chengyong.entity.KWork;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KWorkService {

    int deleteByPrimaryKey(Short wid);

    int deleteByPrimaryKeylow(Short[] wids);

    int insert(KWork record);

    int insertSelective(KWork record);

    KWork selectByPrimaryKey(Short wid);

    int updateByPrimaryKeySelective(KWork record);

    int updateByPrimaryKey(KWork record);

    DataJson booklistResult3(KWork record);

    DataJson booklistResult2(KWork record);

    DataJson booklistResult1(KWork record);

    int updateByWACHNUM1(Short wid,Short wachnum);

    int updateByWACHNUM2(Short wid,Short wachnum);

    String selectByPath(Short wid);

    Integer countKWork(String statyear,String endyear);

    Integer countKWorkdept(String statyear, String endyear);

    Integer countKWorksch(String statyear, String endyear);

}
