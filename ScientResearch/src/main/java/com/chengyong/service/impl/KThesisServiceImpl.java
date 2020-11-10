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

        return kThesisMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int deleteByPrimaryKeylow(Short[] tids) {
        try{
            for (Short tid:tids
            ) {
                kThesisMapper.deleteByPrimaryKey(tid);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insert(KThesis record) {
        String kyname = (String) request.getSession().getAttribute("user");
        String path = (String) request.getSession().getAttribute("paper_path");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setTresource(path);
        return kThesisMapper.insert(record);
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
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KThesis> list  = kThesisMapper.thesislistResult3(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson thesislistResult2(KThesis record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setTdept(kKyuserMapper.selectByDept(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KThesis> list  = kThesisMapper.thesislistResult2(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson thesislistResult1(KThesis record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KThesis> list  = kThesisMapper.thesislistResult1(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByPrimaryKeySelective(KThesis record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KThesis record) {
        String path = (String) request.getSession().getAttribute("paper_path");
        if(path == null){
            return kThesisMapper.updateByPrimaryKey1(record);
        }else{
            record.setTresource(path);
            return kThesisMapper.updateByPrimaryKey(record);
        }

    }

    @Override
    public int updateBytachnum2(Short tid, Short tachnum) {
        if(kThesisMapper.selectBytachnum(tid)==2){
            return 1;
        }
        return kThesisMapper.updateBytachnum2(tid,tachnum);
    }

    @Override
    public int updateBytachnum1(Short tid, Short tachnum) {
        return kThesisMapper.updateBytachnum1(tid,tachnum);
    }

    @Override
    public String selectBypath(Short tid) {
        return kThesisMapper.selectBypath(tid);
    }
}
