package com.chengyong.service;

import com.chengyong.entity.KProjectper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KProjectperService {
    int deleteByPrimaryKey(Short pperid);

    int insert(KProjectper record);

    int insertSelective(KProjectper record);

    KProjectper selectByPrimaryKey(Short pperid);

    int updateByPrimaryKeySelective(KProjectper record);

    int updateByPrimaryKey(KProjectper record);

}
