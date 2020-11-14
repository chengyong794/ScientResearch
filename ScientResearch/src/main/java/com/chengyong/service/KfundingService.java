package com.chengyong.service;

import com.chengyong.entity.Kfunding;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KfundingService {
    int deleteByPrimaryKey(Short jid);

    int insert(Kfunding record);

    int insertSelective(Kfunding record);

    Kfunding selectByPrimaryKey(Short jid);

    int updateByPrimaryKeySelective(Kfunding record);

    int updateByPrimaryKey(Kfunding record);

    DataJson FundingList(Kfunding record);

    DataJson FundingListBykyID(Kfunding record);
}