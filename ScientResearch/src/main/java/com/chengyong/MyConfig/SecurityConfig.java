package com.chengyong.MyConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin().loginPage("/index")
                .and()
                .authorizeRequests()
                .antMatchers("/index","/css/**"
                        ,"/images/**","/js/**"
                        ,"/lib/**","/webjars/html5shiv/3.3.7/**"
                        ,"/webjars/respond/1.4.2/**","/api/**","/menu").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .frameOptions()
                .disable();
        // frameOptions 开启ifram支持
    }
}
