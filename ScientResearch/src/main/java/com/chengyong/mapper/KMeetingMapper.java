package com.chengyong.mapper;

import com.chengyong.entity.KMeeting;

public interface KMeetingMapper {
    int deleteByPrimaryKey(Short mid);

    int insert(KMeeting record);

    int insertSelective(KMeeting record);

    KMeeting selectByPrimaryKey(Short mid);

    int updateByPrimaryKeySelective(KMeeting record);

    int updateByPrimaryKey(KMeeting record);
}