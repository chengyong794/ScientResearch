package com.chengyong.Auth;

import com.chengyong.entity.KKyuser;
import com.chengyong.mapper.KKyuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class MyRbacService {
    @Autowired
    private KKyuserMapper kKyuserMapper;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断我们当前用户访问的url，是否包含在用户能够访问的url地址之内
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal(); //相当于拿到我们的 KKyuser 类
        if(principal instanceof KKyuser){ //如果这个类是 KKyuser
        String un = ((KKyuser) principal).getUsername();
        //获取kyid来 查询url
            List<String> urlList = kKyuserMapper.findRoleMenu(un);
            List<String> roleKNODEURL = kKyuserMapper.findRoleKNODEURL(un);
            for (String str:roleKNODEURL
                 ) {
                urlList.add(str);
            }
            urlList.add("/leftmenu");
            //判断我们拥有的url 是否和 用户访问的url一样
            for (String url:urlList){
                if(url != null){
                    if(antPathMatcher.match(url,request.getRequestURI())){
                        return true;  //一样就返回true
                    }
                }
            }

        }
        return false; //如果当前的访问地址和 我们数据库拥有的url不一致就返回false
    }
}
