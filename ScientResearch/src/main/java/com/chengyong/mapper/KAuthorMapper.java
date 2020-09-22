package com.chengyong.mapper;

import com.chengyong.entity.KAuthor;

public interface KAuthorMapper {
    int deleteByPrimaryKey(Short aid);

    int insert(KAuthor record);

    int insertSelective(KAuthor record);

    KAuthor selectByPrimaryKey(Short aid);

    int updateByPrimaryKeySelective(KAuthor record);

    int updateByPrimaryKey(KAuthor record);
}