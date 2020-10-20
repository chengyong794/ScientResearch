package com.chengyong.service.impl;

import com.chengyong.entity.KProject;
import com.chengyong.mapper.KProjectMapper;
import com.chengyong.service.KProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KProjectServiceImpl implements KProjectService {

    @Autowired
    private KProjectMapper kProjectMapper;

    @Override
    public int deleteByPrimaryKey(Short pid) {
        return 0;
    }

    @Override
    public int insert(KProject record) {
        return kProjectMapper.insert(record);
    }

    @Override
    public int insertSelective(KProject record) {
        return 0;
    }

    @Override
    public KProject selectByPrimaryKey(Short pid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KProject record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KProject record) {
        return 0;
    }

    @Override
    public KProject selectByPnameAndPPEOPLE(KProject kProject) {
        return kProjectMapper.selectByPnameAndPPEOPLE(kProject);
    }
}
