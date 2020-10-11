package com.chengyong.service.impl;

import com.chengyong.entity.Klog;
import com.chengyong.mapper.KlogMapper;
import com.chengyong.service.KlogService;
import com.chengyong.util.DataJson;
import com.chengyong.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class KlogServiceImpl implements KlogService {
    @Autowired
    private KlogMapper klogMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public DataJson listLog(Klog klog) {
        List<Klog> list = (List<Klog>)redisUtil.get("listLog:listLog"+klog.getPage()+klog.getLimit());
        Integer total = (Integer)redisUtil.get("listLog:total"+klog.getPage()+klog.getLimit());
        if(list==null){
            PageHelper.startPage(klog.getPage(),klog.getLimit());
            list = klogMapper.listLog(klog);
            PageInfo info = new PageInfo(list);
            total = (int)info.getTotal();
            redisUtil.set("listLog:listLog"+klog.getPage()+klog.getLimit(),list);
            redisUtil.set("listLog:total"+klog.getPage()+klog.getLimit(),total);
        }

        return new DataJson(total,list);
    }

    @Override
    public DataJson listBy(Klog klog) {
        PageHelper.startPage(klog.getPage(),klog.getLimit());
        List<Klog> list = klogMapper.listLog(klog);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int insert(Klog klog) {
        Set<String> keys = redisUtil.keys("listLog*");
        redisUtil.delkeys(keys);
        return klogMapper.insert(klog);
    }
}
