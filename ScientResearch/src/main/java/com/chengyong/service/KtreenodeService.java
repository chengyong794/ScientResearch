package com.chengyong.service;

import com.chengyong.entity.Ktreenode;
import com.chengyong.util.DataTree;
import org.springframework.stereotype.Service;

@Service
public interface KtreenodeService {
    String deleteByPrimaryKey(Short treenodeid);

    int insert(Ktreenode record);

    int insertSelective(Ktreenode record);

    Ktreenode selectByPrimaryKey(Short treenodeid);

    int updateByPrimaryKeySelective(Ktreenode record);

    int updateByPrimaryKey(Ktreenode record);

    DataTree listTreeNode();
}
