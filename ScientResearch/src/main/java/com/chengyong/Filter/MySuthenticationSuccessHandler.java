package com.chengyong.security.auth;

import com.chengyong.util.LoginJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
springSecurity 登录成功后返回json数据 不反回页面，前后端分离
继承  SavedRequestAwareAuthenticationSuccessHandler
 */
@Component //加入组件
public class MySuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper; //springboot 自带的能够将对象转换成json，也能将json转换成对象

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication) throws ServletException, IOException {

        //设置 为1 表示成功 可以跳转到 /login地址
        LoginJson j = new LoginJson(1,"登录成功","/index");

        if(j!=null){
            //用json做 页面响应
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(j));
        }else{
            //记录上一次请求的地址 ，如果跳转失败就会跳转到上一次记录的地址
            super.onAuthenticationSuccess(request,response,authentication);
        }


    }
}
