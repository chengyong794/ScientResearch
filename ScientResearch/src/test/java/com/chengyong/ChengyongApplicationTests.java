package com.chengyong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ChengyongApplicationTests {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String pwd1 = passwordEncoder.encode("123456");
        String pwd2 = bCryptPasswordEncoder.encode("123456");
        System.out.println(passwordEncoder.matches("123456",pwd1));
        System.out.println(bCryptPasswordEncoder.matches("123456",pwd2));
    }

}
