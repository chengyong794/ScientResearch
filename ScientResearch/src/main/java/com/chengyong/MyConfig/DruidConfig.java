package com.chengyong.MyConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //将 spring.datasource. 为前缀的都加入进来
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
    return new DruidDataSource();
    }

    //配置druid的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletR =
                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,Object> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        map.put("allow", "");
        servletR.setInitParameters(map);
        return servletR;
    }

    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistration =
                new FilterRegistrationBean();
        filterRegistration.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        //除了这些
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        filterRegistration.setInitParameters(initParams);
        //拦截所有请求
        filterRegistration.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistration;
    }
}
