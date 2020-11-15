package com.chengyong.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CodeFilter extends OncePerRequestFilter {
    @Autowired
    private MySuthenticationFailHandler mySuthenticationFailHandler;
    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        if(StringUtils.pathEquals("/login",request.getRequestURI())
                &&"post".equalsIgnoreCase(request.getMethod())){

            //捕获验证码校验失败的异常
            try {
                //该方法用于验证码的验证
                validate(new ServletWebRequest(request));
            }catch (AuthenticationException e){
                mySuthenticationFailHandler.onAuthenticationFailure(
                        request,response,e);
                return; //如果校验失败就直接return 不用执行后面的过滤器链了
            }

        }

        //继续执行过滤器链
        filterChain.doFilter(request,response);

    }

    private void validate(ServletWebRequest webRequest) throws ServletRequestBindingException {
        HttpSession session = webRequest.getRequest().getSession();
        String webCode = ServletRequestUtils.getStringParameter(webRequest.getRequest(),"captcha"); //获取前端的验证码信息
        String sessionCode = (String) session.getAttribute("code");
        if(StringUtils.isEmpty(webCode)){
            throw new SessionAuthenticationException("验证码校验不能为空");
        }

        if(!sessionCode.toUpperCase().equals(webCode.toUpperCase())){
            throw new SessionAuthenticationException("验证码输入错误！");
        }
    }
}
