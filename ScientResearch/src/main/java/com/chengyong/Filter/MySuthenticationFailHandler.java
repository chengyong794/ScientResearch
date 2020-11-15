package com.chengyong.Filter;

import com.chengyong.util.LoginJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转失败的返回 json
 */
@Component
public class MySuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        LoginJson j = new LoginJson(0,"登录失败,请检查账号或者密码","/");
        if(exception instanceof SessionAuthenticationException){ //如果捕获的是校验验证码失败的异常就抛出
            j.setMsg(exception.getMessage()); //将我们验证码类那边抛的message交给我们的json
        }
        if(j!=null){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(j));
        }else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
