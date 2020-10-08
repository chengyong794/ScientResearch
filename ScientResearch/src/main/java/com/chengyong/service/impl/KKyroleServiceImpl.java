package com.chengyong.service.impl;

import com.chengyong.entity.KKyrole;
import com.chengyong.entity.Ktreenode;
import com.chengyong.mapper.KKyroleMapper;
import com.chengyong.service.KKyroleService;
import com.chengyong.util.DataJson;
import com.chengyong.util.RedisUtil;
import com.chengyong.util.Role_Menu_TreeNode;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
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

    @Override
    public List<Role_Menu_TreeNode> Role_Menu_Tree(Short rid) {
        List<Ktreenode> role_menu_tree = kKyroleMapper.Role_Menu_Tree(rid);
        List<Ktreenode> menu_tree = kKyroleMapper.Menu_Tree();

        List<Role_Menu_TreeNode> roleMenuTreeNodeList1 = new ArrayList<>();


        for (Ktreenode m_t:
                menu_tree) {
            Role_Menu_TreeNode role_menu_treeNode = new Role_Menu_TreeNode();
            if(m_t.getType()==1){
                for (Ktreenode r_m_t:role_menu_tree
                     ) {
                    if(r_m_t.getTreenodeid()==m_t.getTreenodeid()){
                        role_menu_treeNode.setChecked(true);
                        break;
                    }
                }
                role_menu_treeNode.setId((int)m_t.getTreenodeid());
                role_menu_treeNode.setTitle(m_t.getTitle());
                List<Role_Menu_TreeNode> roleMenuTreeNodeList = new ArrayList<>();
                for (Ktreenode m_t1 :
                        menu_tree) {
                    Role_Menu_TreeNode role_menu_treeNode1 = new Role_Menu_TreeNode();
                    if (m_t.getTreenodeid()==m_t1.getParentid()) {
                        for (Ktreenode r_m_t:role_menu_tree
                        ) {
                            if(r_m_t.getTreenodeid()==m_t1.getTreenodeid()){
                                role_menu_treeNode1.setChecked(true);
                                break;
                            }
                        }
                        role_menu_treeNode1.setId((int)m_t1.getTreenodeid());
                        role_menu_treeNode1.setTitle(m_t1.getTitle());
                        roleMenuTreeNodeList.add(role_menu_treeNode1);
                    }
                }
                role_menu_treeNode.setChildren(roleMenuTreeNodeList);
                roleMenuTreeNodeList1.add(role_menu_treeNode);
            }

        }

        return roleMenuTreeNodeList1;
    }
}
