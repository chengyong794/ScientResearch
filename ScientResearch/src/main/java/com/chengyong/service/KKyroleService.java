package com.chengyong.service;

import com.chengyong.entity.KKyrole;
import com.chengyong.entity.Ktreenode;
import com.chengyong.util.DataJson;
import com.chengyong.util.Role_Menu_TreeNode;

import java.util.List;

public interface KKyroleService {
    int deleteByPrimaryKey(Short rId);

    int insert(KKyrole record);

    int insertSelective(KKyrole record);

    KKyrole selectByPrimaryKey(Short rId);

    int updateByPrimaryKeySelective(KKyrole record);

    int updateByPrimaryKey(KKyrole record);

    DataJson listRole();

    List<Role_Menu_TreeNode> Role_Menu_Tree(Short rid);

    int insertNode(Short rid,Short[] nodeid);

    int insert_user_role(Short[] ids,Short kyid);

    DataJson listRoleByID(Short kyid);

}
