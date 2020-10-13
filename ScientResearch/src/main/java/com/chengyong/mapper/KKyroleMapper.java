package com.chengyong.mapper;

import com.chengyong.entity.KKyrole;
import com.chengyong.entity.Ktreenode;

import java.util.List;

public interface KKyroleMapper {
    int deleteByPrimaryKey(Short rId);

    int insert(KKyrole record);

    int insertSelective(KKyrole record);

    KKyrole selectByPrimaryKey(Short rId);

    int updateByPrimaryKeySelective(KKyrole record);

    int updateByPrimaryKey(KKyrole record);

    List<KKyrole> listRole();

    List<Ktreenode> Role_Menu_Tree(Short rid);

    List<Ktreenode> Menu_Tree();

    int insertNode(Short rid,Short nodeid);

    int insertKR_URL(Short rid,Short nodeid);

    int insert_user_role(Short kyid,Short rid);

    int delNode(Short rid);

    int delinsertKR_URL(Short rid);

    int del_user_role(Short kyid);

    List<Short> listRoleByID(Short kyid);
}