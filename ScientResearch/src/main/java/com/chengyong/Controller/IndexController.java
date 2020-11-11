package com.chengyong.Controller;

import com.chengyong.entity.KView;
import com.chengyong.service.KKyuserService;
import com.chengyong.service.KviewService;
import com.chengyong.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private KKyuserService kKyuserService;

    @Autowired
    private RedisUtil redisUtil;

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

    /**
     * 权限页跳转
     */
    @RequestMapping("/permisspage")
    public String permisspage(){
        return "page/system/permiss";
    }

    /**
     * 日志页跳转
     */
    @RequestMapping("/logpage")
    public String logpage(){
        return "page/system/log";
    }

    /**
     * 项目申报跳转
     */
    @RequestMapping("/declarepage")
    public String declarepage(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/promanage/declare";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/promanage/declare-2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/promanage/declare-1";
            }
        }else{
            if(KyType==1){
                url = "page/promanage/declare";
            }else if(KyType==2){
                url = "page/promanage/declare-2";
            }else if(KyType==3){
                url = "page/promanage/declare-1";
            }
        }

        return url;
    }

    /**
     * 项目立项跳转
     */
    @RequestMapping("/succproject")
    public String succproject(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/promanage/succ_project1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/promanage/succ_project2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/promanage/succ_project3";
            }
        }else{
            if(KyType==1){
                url = "page/promanage/succ_project1";
            }else if(KyType==2){
                url = "page/promanage/succ_project2";
            }else if(KyType==3){
                url = "page/promanage/succ_project3";
            }
        }

        return url;
    }

    /**
     * 项目中检跳转
     */
    @RequestMapping("/checkproject")
    public String checkproject(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/promanage/check_project1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/promanage/check_project2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/promanage/check_project3";
            }
        }else{
            if(KyType==1){
                url = "page/promanage/check_project1";
            }else if(KyType==2){
                url = "page/promanage/check_project2";
            }else if(KyType==3){
                url = "page/promanage/check_project3";
            }
        }

        return url;
    }

    /**
     * 项目结项跳转
     */
    @RequestMapping("/endproject")
    public String endproject(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/promanage/end_project1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/promanage/end_project2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/promanage/end_project3";
            }
        }else{
            if(KyType==1){
                url = "page/promanage/end_project1";
            }else if(KyType==2){
                url = "page/promanage/end_project2";
            }else if(KyType==3){
                url = "page/promanage/end_project3";
            }
        }

        return url;
    }

    /**
     * 项目延期跳转
     */
    @RequestMapping("/delayproject")
    public String delayproject(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/promanage/delay_project1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/promanage/delay_project2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/promanage/delay_project3";
            }
        }else{
            if(KyType==1){
                url = "page/promanage/delay_project1";
            }else if(KyType==2){
                url = "page/promanage/delay_project2";
            }else if(KyType==3){
                url = "page/promanage/delay_project3";
            }
        }

        return url;
    }

    /**
     * 项目终止跳转
     */
    @RequestMapping("/Termination_project")
    public String Termination_project(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/promanage/Termination_project1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/promanage/Termination_project2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/promanage/Termination_project3";
            }
        }else{
            if(KyType==1){
                url = "page/promanage/Termination_project1";
            }else if(KyType==2){
                url = "page/promanage/Termination_project2";
            }else if(KyType==3){
                url = "page/promanage/Termination_project3";
            }
        }

        return url;
    }


    /**
     * 规章制度跳转
     */
    @RequestMapping("/rules")
    public String rules(){
        return "page/systemhelp/rules";
    }

    /**
     * 用户手册跳转
     */
    @RequestMapping("/syshelp")
    public String syshelp(){
        return "page/systemhelp/syshelp";
    }

    /**
     * 论文页面跳转
     */
    @RequestMapping("/kthesis_results")
    public String kthesis_results(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/results/paper_results1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/results/paper_results2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/results/paper_results3";
            }
        }else{
            if(KyType==1){
                url = "page/results/paper_results1";
            }else if(KyType==2){
                url = "page/results/paper_results2";
            }else if(KyType==3){
                url = "page/results/paper_results3";
            }
        }

        return url;
    }

    /**
     * 著作页面跳转
     */
    @RequestMapping("/kbook_results")
    public String kbook_results(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/results/book_results1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/results/book_results2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/results/book_results3";
            }
        }else{
            if(KyType==1){
                url = "page/results/book_results1";
            }else if(KyType==2){
                url = "page/results/book_results2";
            }else if(KyType==3){
                url = "page/results/book_results3";
            }
        }

        return url;
    }

    /**
     * 项目成果页面跳转
     */
    @RequestMapping("/project_results")
    public String project_results(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/results/project_results1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/results/project_results2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/results/project_results3";
            }
        }else{
            if(KyType==1){
                url = "page/results/project_results1";
            }else if(KyType==2){
                url = "page/results/project_results2";
            }else if(KyType==3){
                url = "page/results/project_results3";
            }
        }

        return url;
    }
}
