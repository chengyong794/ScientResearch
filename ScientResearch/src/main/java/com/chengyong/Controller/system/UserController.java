package com.chengyong.Controller.system;

import com.chengyong.entity.KKyuser;
import com.chengyong.service.KKyuserService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息的处理
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private KKyuserService kKyuserService;

    @RequestMapping("/listUser")
    @ResponseBody
    public DataJson listUser(KKyuser kKyuser){
            DataJson dataJson = kKyuserService.listUser(kKyuser);
            return dataJson;
    }

    @RequestMapping("/searchUser")
    @ResponseBody
    public DataJson searchUser(KKyuser kKyuser){
        DataJson dataJson = kKyuserService.listUser(kKyuser);
        return dataJson;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String,Object> addUser(KKyuser kKyuser){
        Map<String,Object> map = new HashMap<>();
        if(kKyuserService.addUser(kKyuser)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
            return map;
        }

    }

    @RequestMapping("/editUser")
    @ResponseBody
    public Map<String,Object> editUser(KKyuser kKyuser){
        Map<String,Object> map = new HashMap<>();
        if(kKyuserService.editUser(kKyuser)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
            return map;
        }
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public Map<String,Object> delUser(@Param("kyid") Short kyid){
        Map<String,Object> map = new HashMap<>();
        if(kKyuserService.delUser(kyid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
            return map;
        }
    }

    @RequestMapping("/dellowUser")
    @ResponseBody
    public Map<String,Object> dellowUser(@Param("kyids") Short[] kyids){
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < kyids.length; i++) {
            if(kKyuserService.delUser(kyids[i])>0){
                map.put("info", PUBLIC_ATTRIBUTE.DELETE);
            }else{
                map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
                break;
            }
        }
        return map;
    }
}
