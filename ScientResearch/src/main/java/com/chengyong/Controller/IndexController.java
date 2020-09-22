package com.chengyong.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 进入登录页的控制器
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String loginpage(){
        //templates 默认前缀就是templates
        return "page/login";
    }

    @RequestMapping("/index")
    public String index(){
        //templates 默认前缀就是templates
        return "index";
    }

    @RequestMapping("/menu")
    public String menu(){
        //templates 默认前缀就是templates
        return "page/menu";
    }
}
