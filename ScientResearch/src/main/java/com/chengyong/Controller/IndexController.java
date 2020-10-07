package com.chengyong.Controller;

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

    /**
     * 登录页跳转
     * @return
     */
    @RequestMapping("/")
    public String loginpage(){
        //templates 默认前缀就是templates
        return "page/login";
    }

    /**
     * 首页跳转
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        //templates 默认前缀就是templates
        return "index";
    }

    /**
     * 左侧分级菜单
     * @return
     */
    @RequestMapping("/leftmenu")
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

    /**
     * 菜单页面跳转
     * @return
     */
    @RequestMapping("/rightmenu")
    public String rightmenu(){
        return "page/system/menu";
    }

    /**
     * 首页欢迎页跳转
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        //templates 默认前缀就是templates
        return "page/welcome-1";
    }

    /**
     * 用户页跳转
     * @return
     */
    @RequestMapping("/userpage")
    public String userpage(){
        return "page/system/user";
    }

    /**
     * 角色页跳转
     */
    @RequestMapping("/rolepage")
    public String rolepage(){
        return "page/system/role";
    }
}
