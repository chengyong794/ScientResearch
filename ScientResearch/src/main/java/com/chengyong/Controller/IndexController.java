package com.chengyong.Controller;

import com.chengyong.entity.Ktreenode;
import com.chengyong.entity.KView;
import com.chengyong.service.KviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 进入登录页的控制器
 */
@Controller
public class IndexController {

    @Autowired
    private KviewService kviewService;

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

    /**
     * 显示分级菜单
     * @return
     */
    @RequestMapping("/menu")
    @ResponseBody
    public Map<String,Object> menu(){
        Map<String,Object> map = new HashMap<>();
        KView homeInfo = kviewService.findById((short)1);
        KView logoInfo = kviewService.findById((short)2);
        List<KView> menuInfo = kviewService.selectKview();
        map.put("homeInfo",homeInfo);
        map.put("logoInfo",logoInfo);
        map.put("menuInfo",menuInfo);
        return map;
    }

    @RequestMapping("/welcome")
    public String welcome(){
        //templates 默认前缀就是templates
        return "page/welcome-1";
    }
}
