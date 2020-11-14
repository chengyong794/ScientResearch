package com.chengyong.service.impl;

import com.chengyong.entity.KPostproject;
import com.chengyong.entity.Kfunding;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KfundingMapper;
import com.chengyong.service.KfundingService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KfundingServiceImpl implements KfundingService {

    @Autowired
    private KfundingMapper kfundingMapper;

    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public int deleteByPrimaryKey(Short jid) {
        return 0;
    }

    @Override
    public int insert(Kfunding record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        return kfundingMapper.insert(record);
    }

    @Override
    public int insertSelective(Kfunding record) {
        return 0;
    }

    @Override
    public Kfunding selectByPrimaryKey(Short jid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Kfunding record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Kfunding record) {
        Double fund = record.getTotalfund() - record.getDistri();
        if(fund<0){
            return 2;
        }else{
            record.setTotalfund(fund);
            return kfundingMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    public DataJson FundingList(Kfunding record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<Kfunding> list = kfundingMapper.FundingList(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson FundingListBykyID(Kfunding record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<Kfunding> list = kfundingMapper.FundingList(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }
}
