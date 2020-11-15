package com.chengyong.MyConfig;

import com.chengyong.Filter.MySuthenticationFailHandler;
import com.chengyong.service.KKyuserService;
import com.chengyong.Filter.CodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private KKyuserService kKyuserService;

    @Autowired
    private CodeFilter codeFilter;

    @Autowired
    private com.chengyong.security.auth.MySuthenticationSuccessHandler mySuthenticationSuccessHandler;

    @Autowired
    private MySuthenticationFailHandler mySuthenticationFailHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http .addFilterBefore(codeFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .logout()
                .and().rememberMe()//开启记住密码
                .rememberMeCookieName("fjduidcyfejc")//存浏览器的cookie名称，为了安全可以随便乱写
                .tokenValiditySeconds(600) //记住密码的使用时间
                .and()
                .formLogin().loginPage("/")
                .loginProcessingUrl("/login")
                //.successForwardUrl("/index")
                .successHandler(mySuthenticationSuccessHandler)
                .failureHandler(mySuthenticationFailHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**"
                        ,"/images/**","/js/**"
                        ,"/lib/**","/webjars/html5shiv/3.3.7/**"
                        ,"/webjars/respond/1.4.2/**","/api/**","/favicon.ico","/code/kycode")
                .permitAll()
                .antMatchers("/index")
                .authenticated()
                .anyRequest()
                .access("@myRbacService.hasPermission(request,authentication)")//进行权限配置,这里必须要按照这样写 request，authentication
                .and()
                .headers()
                .frameOptions() // frameOptions 开启ifram支持
                .disable()
                .and()
                .sessionManagement()
                .maximumSessions(1) //最多允许一个账号同时登录
                .maxSessionsPreventsLogin(false); //如果有另外一个账号登录就 把另一个挤下去

    }

    /**
     * 密码配置
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(kKyuserService)
        .passwordEncoder(passwordEncoder());
    }


    /**
     * 角色密码 BCrypt加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
