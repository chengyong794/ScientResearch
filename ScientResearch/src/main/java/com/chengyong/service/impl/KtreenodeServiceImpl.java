package com.chengyong.service.impl;

import com.chengyong.entity.Ktreenode;
import com.chengyong.mapper.KtreenodeMapper;
import com.chengyong.service.KtreenodeService;
import com.chengyong.util.DataTree;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KtreenodeServiceImpl implements KtreenodeService {
    @Autowired
    private KtreenodeMapper ktreenodeMapper;
    @Override
    public int deleteByPrimaryKey(Short treenodeid) {
        return 0;
    }

    @Override
    public int insert(Ktreenode record) {
        return 0;
    }

    @Override
    public int insertSelective(Ktreenode record) {
        return 0;
    }

    @Override
    public Ktreenode selectByPrimaryKey(Short treenodeid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Ktreenode record) {
        return ktreenodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Ktreenode record) {
        return ktreenodeMapper.updateByPrimaryKey(record);
    }

    @Cacheable("listTreeNode")
    @Override
    public DataTree listTreeNode() {
        List<Ktreenode> list = ktreenodeMapper.listTreeNode();
        PageInfo<Ktreenode> listInfo = new PageInfo<>();
        return new DataTree(listInfo.getTotal(),list);
    }
}
