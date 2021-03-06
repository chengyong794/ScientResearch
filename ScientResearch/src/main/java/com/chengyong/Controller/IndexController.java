package com.chengyong.Controller;

import com.chengyong.entity.KKyuser;
import com.chengyong.entity.KNotice;
import com.chengyong.entity.KView;
import com.chengyong.mapper.KNoticeMapper;
import com.chengyong.service.KKyuserService;
import com.chengyong.service.KNoticeService;
import com.chengyong.service.KviewService;
import com.chengyong.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    private KNoticeMapper kNoticeMapper;

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
    public ModelAndView welcome(){
        ModelAndView mod = new ModelAndView("page/welcome-1");
        List<KNotice> list = kNoticeMapper.ListNotice(new KNotice());
        mod.addObject("list",list);
        return mod;
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

    /**
     * 专利页面跳转
     */
    @RequestMapping("/patent_results")
    public String patent_results(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/results/patent_results1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/results/patent_results2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/results/patent_results3";
            }
        }else{
            if(KyType==1){
                url = "page/results/patent_results1";
            }else if(KyType==2){
                url = "page/results/patent_results2";
            }else if(KyType==3){
                url = "page/results/patent_results3";
            }
        }

        return url;
    }

    /**
     * 科研业绩页面跳转
     */
    @RequestMapping("/personal_performance")
    public String personal_performance(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/performance/personal_performance1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/performance/personal_performance2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/performance/personal_performance3";
            }
        }else{
            if(KyType==1){
                url = "page/performance/personal_performance1";
            }else if(KyType==2){
                url = "page/performance/personal_performance2";
            }else if(KyType==3){
                url = "page/performance/personal_performance3";
            }
        }

        return url;
    }

    /**
     * 三年科研业绩页面跳转
     */
    @RequestMapping("/Three__performance")
    public String Three__performance(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/performance/three_performance1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/performance/three_performance2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/performance/three_performance3";
            }
        }else{
            if(KyType==1){
                url = "page/performance/three_performance1";
            }else if(KyType==2){
                url = "page/performance/three_performance2";
            }else if(KyType==3){
                url = "page/performance/three_performance3";
            }
        }

        return url;
    }

    /**
     * 院系科研业绩页面跳转
     */
    @RequestMapping("/dept__performance")
    public String dept__performance(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/performance/dept_performance1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/performance/dept_performance2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/performance/dept_performance3";
            }
        }else{
            if(KyType==1){
                url = "page/performance/dept_performance1";
            }else if(KyType==2){
                url = "page/performance/dept_performance2";
            }else if(KyType==3){
                url = "page/performance/dept_performance3";
            }
        }

        return url;
    }

    /**
     * 科研经费页面跳转
     */
    @RequestMapping("/fund__compre")
    public String fund__compre(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/compre/fund_project1";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/compre/fund_project3";
            }
        }else{
            if(KyType==1){
                url = "page/compre/fund_project1";
            }else if(KyType==3){
                url = "page/compre/fund_project3";
            }
        }

        return url;
    }

    /**
     * 消息页面跳转
     */
    @RequestMapping("/message__compre")
    public String message__compre(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/compre/message1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/compre/message2";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/compre/message3";
            }
        }else{
            if(KyType==1){
                url = "page/compre/message1";
            }else if(KyType==2){
                url = "page/compre/message2";
            }else if(KyType==3){
                url = "page/compre/message3";
            }
        }

        return url;
    }

    /**
     * 公告管理页面跳转
     */
    @RequestMapping("/notice__compre")
    public String notice__compre(HttpServletRequest request){
        String url = null;
        String un = (String) request.getSession().getAttribute("user");
        Integer KyType = (Integer) redisUtil.get(un);

        if(KyType==null){
            Short tp = kKyuserService.findUserRoleType(un);
            if(tp==1||tp==0){
                redisUtil.set("KyType",tp);
                url = "page/compre/welcome1";
            }else if(tp==2){
                redisUtil.set("KyType",tp);
                url = "page/compre/null";
            }else if(tp==3){
                redisUtil.set("KyType",tp);
                url = "page/compre/null";
            }
        }else{
            if(KyType==1){
                url = "page/compre/welcome1";
            }else if(KyType==2){
                url = "page/compre/null";
            }else if(KyType==3){
                url = "page/compre/null";
            }
        }

        return url;
    }

    /**
     * 用户个人信息页面跳转
     */
    @RequestMapping("/user_set")
    public ModelAndView user_set(HttpServletRequest request){
        ModelAndView mod = new ModelAndView("page/user/user-setting");
        String un = (String) request.getSession().getAttribute("user");
        KKyuser kKyuser = kKyuserService.selectByPrimaryName(un);
        mod.addObject("user",kKyuser);
        return mod;
    }

    /**
     * 用户修改密码页面跳转
     */
    @RequestMapping("/password_set")
    public String password_set(HttpServletRequest request){

        return "page/user/user-password";
    }
}
