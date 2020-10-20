package com.chengyong.service.impl;

import com.chengyong.entity.KProjectper;
import com.chengyong.mapper.KProjectperMapper;
import com.chengyong.service.KProjectperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KProjectperServiceImpl implements KProjectperService {

    @Autowired
    private KProjectperMapper kProjectperMapper;

    @Override
    public int deleteByPrimaryKey(Short pperid) {
        return 0;
    }

    @Override
    public int insert(KProjectper record) {
        return kProjectperMapper.insert(record);
    }

    @Override
    public int insertSelective(KProjectper record) {
        return 0;
    }

    @Override
    public KProjectper selectByPrimaryKey(Short pperid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KProjectper record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KProjectper record) {
        return 0;
    }


}
