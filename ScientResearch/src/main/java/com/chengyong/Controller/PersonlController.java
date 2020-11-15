package com.chengyong.Controller;

import com.chengyong.entity.KKyuser;
import com.chengyong.service.KKyuserService;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/personl")
public class PersonlController {

    @Autowired
    private KKyuserService kKyuserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/updatePersonl")
    public Map<String,Object> updatePersonl(KKyuser kKyuser){
        Map<String,Object> map = new HashMap<>();
        if(kKyuserService.updatePersonl(kKyuser)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
            return map;
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
            return map;
        }
    }

    @RequestMapping("/updatePassword")
    public Map<String,Object> updatePassword(
            @Param("old_password") String old_password,
            @Param("new_password") String new_password,
            @Param("again_password") String again_password
    ){
        Map<String,Object> map = new HashMap<>();

        String kyname = (String) request.getSession().getAttribute("user");
        Short kyid = kKyuserService.selectByuname(kyname);

        String SQLpwd = kKyuserService.selectByPassword(kyid);

        boolean f = bCryptPasswordEncoder.matches(old_password,SQLpwd);

        if(!f){
            map.put("info", PUBLIC_ATTRIBUTE.PWD_ERROR);
        }else if(!new_password.equals(again_password)){
            map.put("info", PUBLIC_ATTRIBUTE.AGPWD_ERROR);
        }else{
            KKyuser kKyuser = new KKyuser();
            kKyuser.setPassword(bCryptPasswordEncoder.encode(new_password));
            kKyuser.setKyid(kyid);
            if(kKyuserService.updatePwd(kKyuser)>0){
                map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
            }else{
                map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
            }
        }
        return map;
    }
}
