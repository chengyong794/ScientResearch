package com.chengyong.MyConfig;

import com.chengyong.service.KKyuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private KKyuserService kKyuserService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .logout()
                .and()
                .formLogin().loginPage("/")
                .loginProcessingUrl("/login")
                .successForwardUrl("/index")
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**"
                        ,"/images/**","/js/**"
                        ,"/lib/**","/webjars/html5shiv/3.3.7/**"
                        ,"/webjars/respond/1.4.2/**","/api/**","/favicon.ico")
                .permitAll()
                .antMatchers("/menu")
                .hasAnyAuthority("ROLE_SUPER")
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .frameOptions()
                .disable();
        // frameOptions 开启ifram支持
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
