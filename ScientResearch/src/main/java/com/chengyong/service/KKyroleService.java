package com.chengyong.service;

import com.chengyong.entity.KKyrole;
import com.chengyong.util.DataJson;

import java.util.List;

public interface KKyroleService {
    int deleteByPrimaryKey(Short rId);

    int insert(KKyrole record);

    int insertSelective(KKyrole record);

    KKyrole selectByPrimaryKey(Short rId);

    int updateByPrimaryKeySelective(KKyrole record);

    int updateByPrimaryKey(KKyrole record);

    DataJson listRole();
}
