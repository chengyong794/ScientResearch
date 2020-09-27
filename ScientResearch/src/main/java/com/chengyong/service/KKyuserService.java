package com.chengyong.service;

import com.chengyong.entity.KKyuser;
import com.chengyong.mapper.KKyuserMapper;
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

    @Cacheable("loadUserByUsername")  //开启注解
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取用户信息
        KKyuser kKyuser = kkyuserMapper.loginUsername(username);
        //根据用户id 查询用户权限信息
        List<String> kKyrole = kkyuserMapper.findUserRole(kKyuser.getKyid());
        //根据权限id  查询用户的菜单
        List<String> kKymenu = kkyuserMapper.findRoleMenu(kKyuser.getKyid());

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
