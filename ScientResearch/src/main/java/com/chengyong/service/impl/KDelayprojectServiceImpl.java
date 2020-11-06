package com.chengyong.service.impl;

import com.chengyong.entity.KDelayproject;
import com.chengyong.entity.KProject;
import com.chengyong.mapper.KDelayprojectMapper;
import com.chengyong.mapper.KProjectMapper;
import com.chengyong.service.KDelayprojectService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KDelayprojectServiceImpl implements KDelayprojectService {

    @Autowired
    private KDelayprojectMapper kDelayprojectMapper;

    @Autowired
    private KProjectMapper kProjectMapper;

    @Override
    public int deleteByPrimaryKey(Short pdelayid) {
        return 0;
    }

    @Override
    public int insert(KDelayproject record) {
        return kDelayprojectMapper.insert(record);
    }

    @Override
    public int insertSelective(KDelayproject record) {
        return 0;
    }

    @Override
    public KDelayproject selectByPrimaryKey(Short pdelayid) {
        return null;
    }

    @Override
    public String selectDelaypath(Short pdelayid) {
        return kDelayprojectMapper.selectDelaypath(pdelayid);
    }

    @Override
    public DataJson delaylistProject1(KDelayproject record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KDelayproject> list = kDelayprojectMapper.delaylistProject1(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson delaylistProject2(KDelayproject record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KDelayproject> list = kDelayprojectMapper.delaylistProject2(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByPYQ1(Short pyq1, Short pdelayid,Short pid) {
        kProjectMapper.updateByPYQ1(pid,pyq1);
        return kDelayprojectMapper.updateByPYQ1(pyq1, pdelayid);
    }

    @Override
    public int updateByPYQ2(Short pyq2, Short pdelayid,Short pid) {
        kProjectMapper.updateByPYQ2(pid,pyq2);
        return kDelayprojectMapper.updateByPYQ2(pyq2, pdelayid);
    }

    @Override
    public int updateByPrimaryKeySelective(KDelayproject record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KDelayproject record) {
        return 0;
    }
}
