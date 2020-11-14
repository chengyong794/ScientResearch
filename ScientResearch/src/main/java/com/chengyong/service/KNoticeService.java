package com.chengyong.service;

import com.chengyong.entity.KNotice;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KNoticeService {

    int deleteByPrimaryKey(Short nid);

    int deleteByPrimaryKeylow(Short[] nids);

    int insert(KNotice record);

    int insertSelective(KNotice record);

    KNotice selectByPrimaryKey(Short nid);

    int updateByPrimaryKeySelective(KNotice record);

    int updateByPrimaryKey(KNotice record);

    DataJson ListNotice(KNotice record);
}
