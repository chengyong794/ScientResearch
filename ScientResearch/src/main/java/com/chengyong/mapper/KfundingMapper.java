package com.chengyong.mapper;

import com.chengyong.entity.Kfunding;

import java.util.List;

public interface KfundingMapper {
    int deleteByPrimaryKey(Short jid);

    int insert(Kfunding record);

    int insertSelective(Kfunding record);

    Kfunding selectByPrimaryKey(Short jid);

    int updateByPrimaryKeySelective(Kfunding record);

    int updateByPrimaryKey(Kfunding record);

    List<Kfunding> FundingList(Kfunding record);

    List<Kfunding> FundingListBykyID(Kfunding record);
}