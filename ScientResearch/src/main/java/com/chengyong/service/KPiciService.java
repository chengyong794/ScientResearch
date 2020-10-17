package com.chengyong.service;

import com.chengyong.entity.KPici;
import com.chengyong.util.DataJson;

import java.util.List;

public interface KPiciService {
    int deldeclarelot(Short pcid);

    int deleteByPrimaryKey(Short pcid);

    int insert(KPici record);

    int insertSelective(KPici record);

    KPici selectByPrimaryKey(Short pcid);

    int updateByPrimaryKeySelective(KPici record);

    int updateByPrimaryKey(KPici record);

    DataJson listdeclare(KPici record);

    DataJson searchdeclare(KPici record);
}
