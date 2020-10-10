package com.chengyong.Controller.system;


import com.chengyong.service.KKyroleService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/permiss")
public class PermissController {

    @Autowired
    private KKyroleService kKyroleService;

    @RequestMapping("/listRole")
    public DataJson listRoleByID(@Param("kyid") Short kyid){
        return kKyroleService.listRoleByID(kyid);
    }

    @RequestMapping("/addPermiss")
    public Map<String,Object> addPermiss(@Param("ids") Short[] ids,@Param("kyid") Short kyid){
        Map<String,Object> map = new HashMap<>();
        if(kKyroleService.insert_user_role(ids,kyid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
            return map;
        }
    }
}
