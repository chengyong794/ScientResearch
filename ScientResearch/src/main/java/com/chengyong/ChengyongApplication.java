package com.chengyong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.chengyong.mapper")
@EnableCaching  //开启缓存
public class ChengyongApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChengyongApplication.class, args);
    }

}
