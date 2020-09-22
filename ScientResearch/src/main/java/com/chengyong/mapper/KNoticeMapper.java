package com.chengyong.mapper;

import com.chengyong.entity.KNotice;

public interface KNoticeMapper {
    int deleteByPrimaryKey(Short nid);

    int insert(KNotice record);

    int insertSelective(KNotice record);

    KNotice selectByPrimaryKey(Short nid);

    int updateByPrimaryKeySelective(KNotice record);

    int updateByPrimaryKey(KNotice record);
}