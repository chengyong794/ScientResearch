package com.chengyong.service.impl;

import com.chengyong.entity.KKyrole;
import com.chengyong.mapper.KKyroleMapper;
import com.chengyong.service.KKyroleService;
import com.chengyong.util.DataJson;
import com.chengyong.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

@Service
public class KKyroleServiceImpl implements KKyroleService {

    @Autowired
    private KKyroleMapper kKyroleMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int deleteByPrimaryKey(Short rId) {
        redisUtil.del("listRole");
        return kKyroleMapper.deleteByPrimaryKey(rId);
    }

    @Override
    public int insert(KKyrole record) {
        redisUtil.del("listRole");
        return kKyroleMapper.insert(record);
    }

    @Override
    public int insertSelective(KKyrole record) {
        return 0;
    }

    @Override
    public KKyrole selectByPrimaryKey(Short rId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KKyrole record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KKyrole record) {
        redisUtil.del("listRole");
        return kKyroleMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataJson listRole() {
        List<KKyrole> list = (List<KKyrole>)redisUtil.get("listRole");
        if(list == null){
            list = kKyroleMapper.listRole();
            redisUtil.set("listRole",list);
        }
        return new DataJson(10,list);
    }
}
