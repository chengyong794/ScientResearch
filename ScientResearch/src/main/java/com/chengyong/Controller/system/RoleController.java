package com.chengyong.Controller.system;

import com.chengyong.entity.KKyrole;
import com.chengyong.service.KKyroleService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import com.chengyong.util.Role_Menu_TreeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private KKyroleService kKyroleService;

    @RequestMapping("/listRole")
    public DataJson listRole(){
        return kKyroleService.listRole();
    }

    @RequestMapping("/addRole")
    public Map<String,Object> addRole(KKyrole kKyrole){
        Map<String,Object> map = new HashMap<>();
        if(kKyroleService.insert(kKyrole)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
            return map;
        }
    }

    @RequestMapping("/editRole")
    public Map<String,Object> editRole(KKyrole kKyrole){
        Map<String,Object> map = new HashMap<>();
        if(kKyroleService.updateByPrimaryKey(kKyrole)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
            return map;
        }
    }

    @RequestMapping("/delRole")
    public Map<String,Object> delRole(@Param("rId") Short rId){
        Map<String,Object> map = new HashMap<>();
        if(kKyroleService.deleteByPrimaryKey(rId)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
            return map;
        }
    }

    @RequestMapping("/RoleMenuTree")
    public List<Role_Menu_TreeNode> Role_Menu_Tree(@Param("rId") Short rId){
         return  kKyroleService.Role_Menu_Tree(rId);
    }

    /**
     * 添加菜单树节点
     * @param rid,nodeid
     * @return
     */
    @RequestMapping("/addNode")
    public Map<String,Object> addNode(@Param("rid") Short rid,@Param("nodeid") Short[] nodeid){
        Map<String,Object> map = new HashMap<>();
        if(kKyroleService.insertNode(rid,nodeid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
            return map;
        }
    }
}
