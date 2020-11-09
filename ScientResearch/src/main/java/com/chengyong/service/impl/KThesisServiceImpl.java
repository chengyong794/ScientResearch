package com.chengyong.service.impl;

import com.chengyong.entity.KProject;
import com.chengyong.entity.KThesis;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KThesisMapper;
import com.chengyong.service.KThesisService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KThesisServiceImpl implements KThesisService {

    @Autowired
    private KThesisMapper kThesisMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Override
    public int deleteByPrimaryKey(Short tid) {
        return 0;
    }

    @Override
    public int insert(KThesis record) {
        return 0;
    }

    @Override
    public int insertSelective(KThesis record) {
        return 0;
    }

    @Override
    public KThesis selectByPrimaryKey(Short tid) {
        return null;
    }

    @Override
    public DataJson thesislistResult3(KThesis record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setTdept(kKyuserMapper.selectByDept(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KThesis> list  = kThesisMapper.thesislistResult3(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByPrimaryKeySelective(KThesis record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KThesis record) {
        return 0;
    }
}
