package com.chengyong.mapper;

import com.chengyong.entity.Ktreenode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface KtreenodeMapper {
    int deleteByPrimaryKey(Short treenodeid);

    int insert(Ktreenode record);

    int insertSelective(Ktreenode record);

    Ktreenode selectByPrimaryKey(Short treenodeid);

    int updateByPrimaryKeySelective(Ktreenode record);

    int updateByPrimaryKey(Ktreenode record);

    List<Ktreenode> listTreeNode();
}