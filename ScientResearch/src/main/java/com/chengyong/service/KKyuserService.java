package com.chengyong.service;

import com.chengyong.entity.KKyuser;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * springSecurity数据库验证
 */
@Component
public class KKyuserService implements UserDetailsService {
    @Autowired
    private KKyuserMapper kkyuserMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        KKyuser kKyuser = (KKyuser) redisUtil.get("loadUserByUsername");

        if(null == kKyuser){
            //获取用户信息
            kKyuser = kkyuserMapper.loginUsername(username);
            redisUtil.set("loadUserByUsername",kKyuser);
        }

        List<String> kKyrole = (List<String>)redisUtil.get("findUserRole"+kKyuser.getKyid());
        if(null == kKyrole){
            //根据用户id 查询用户权限信息
            kKyrole = kkyuserMapper.findUserRole(kKyuser.getKyid());
            redisUtil.set("findUserRole"+kKyuser.getKyid(),kKyrole);
        }

        List<String> kKymenu = (List<String>)redisUtil.get("findRoleMenu"+kKyuser.getKyid());
        if(null == kKymenu){
            //根据权限id  查询用户的菜单
            kKymenu = kkyuserMapper.findRoleMenu(kKyuser.getKyid());
            redisUtil.set("findRoleMenu"+kKyuser.getKyid(),kKymenu);
        }

        //将角色加入到 菜单一起
        kKymenu.addAll(kKyrole);
        //需要什么就给什么
        kKyuser.setAuthorities(
                AuthorityUtils.
                        commaSeparatedStringToAuthorityList(
                                String.join(",",kKymenu)
                        )
        );
        return kKyuser;
    }
}
