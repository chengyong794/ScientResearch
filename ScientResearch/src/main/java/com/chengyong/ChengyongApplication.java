package com.chengyong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.chengyong.mapper")
public class ChengyongApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChengyongApplication.class, args);
    }

}
