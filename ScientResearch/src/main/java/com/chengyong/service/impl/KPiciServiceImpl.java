package com.chengyong.service.impl;

import com.chengyong.entity.KPici;
import com.chengyong.mapper.KPiciMapper;
import com.chengyong.service.KPiciService;
import com.chengyong.util.DataJson;
import com.chengyong.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class KPiciServiceImpl implements KPiciService {

    @Autowired
    private KPiciMapper kPiciMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int deldeclarelot(Short pcid) {
        return kPiciMapper.deleteByPrimaryKey(pcid);
    }

    @Override
    public int deleteByPrimaryKey(Short pcid) {
        Set<String> keys = redisUtil.keys("listdeclare*");
        redisUtil.delkeys(keys);
        return kPiciMapper.deleteByPrimaryKey(pcid);
    }

    @Override
    public int insert(KPici record) {
        Set<String> keys = redisUtil.keys("listdeclare*");
        redisUtil.delkeys(keys);
        return kPiciMapper.insert(record);
    }

    @Override
    public int insertSelective(KPici record) {
        return 0;
    }

    @Override
    public KPici selectByPrimaryKey(Short pcid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KPici record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KPici record) {
        Set<String> keys = redisUtil.keys("listdeclare*");
        redisUtil.delkeys(keys);
        return kPiciMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataJson listdeclare(KPici record) {
        List<KPici> list = (List<KPici>)redisUtil.get("listdeclare:listdeclare"+record.getPage()+record.getLimit());
        Integer total = (Integer) redisUtil.get("listdeclare:listdeclaretotal"+record.getPage()+record.getLimit());
        if(list == null){
            PageHelper.startPage(record.getPage(),record.getLimit());
            list = kPiciMapper.listdeclare(record);
            PageInfo info = new PageInfo(list);
            total = (int)info.getTotal();
            redisUtil.set("listdeclare:listdeclare"+record.getPage()+record.getLimit(),list);
            redisUtil.set("listdeclare:listdeclaretotal"+record.getPage()+record.getLimit(),total);
        }


        return new DataJson(total,list);
    }

    @Override
    public DataJson searchdeclare(KPici record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KPici> list = kPiciMapper.listdeclare(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }
}
