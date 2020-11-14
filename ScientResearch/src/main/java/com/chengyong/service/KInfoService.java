package com.chengyong.service;

import com.chengyong.entity.KInfo;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KInfoService {
    int deleteByPrimaryKey(Short iid);

    int insert(KInfo record,Short kyid);

    int insertlow(KInfo record,Short[] kyids);

    int insertSelective(KInfo record);

    KInfo selectByPrimaryKey(Short iid);

    int updateByPrimaryKeySelective(KInfo record);

    int updateByPrimaryKey(KInfo record);

    DataJson MessageList(KInfo record);

    String selectByPath(Short iid);
}
