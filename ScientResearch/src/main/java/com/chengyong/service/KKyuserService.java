package com.chengyong.service;

import com.chengyong.Controller.echart.EchartController;
import com.chengyong.entity.KKyuser;
import com.chengyong.entity.Klog;
import com.chengyong.mapper.KKyroleMapper;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KlogMapper;
import com.chengyong.util.DataJson;
import com.chengyong.util.RedisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.lettuce.core.StrAlgoArgs.Builder.keys;

/**
 * springSecurity数据库验证
 */
@Component
public class KKyuserService implements UserDetailsService {
    @Autowired
    private KKyuserMapper kkyuserMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private KKyroleMapper kKyroleMapper;

    @Autowired
    private KlogService klogService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        request.getSession().setAttribute("user",username);
        KKyuser kKyuser = (KKyuser) redisUtil.get("loadUserByUsername"+username);


        if(null == kKyuser){
            //获取用户信息
            kKyuser = kkyuserMapper.loginUsername(username);
            redisUtil.set("loadUserByUsername"+username,kKyuser);
        }

        List<String> kKyrole = (List<String>)redisUtil.get("findUserRole"+kKyuser.getKyid());
        if(null == kKyrole){
            //根据用户id 查询用户权限信息
            kKyrole = kkyuserMapper.findUserRole(kKyuser.getKyid());
            redisUtil.set("findUserRole"+kKyuser.getKyid(),kKyrole);
        }

        List<String> kKymenu = (List<String>)redisUtil.get("findRoleMenu"+kKyuser.getKyid());
        if(null == kKymenu){
            //根据权限id  查询用户的菜单
            kKymenu = kkyuserMapper.findRoleMenu(kKyuser.getUsername());
            redisUtil.set("findRoleMenu"+kKyuser.getKyid(),kKymenu);
        }

        //将角色加入到 菜单一起
        kKymenu.addAll(kKyrole);
        //需要什么就给什么
        kKyuser.setAuthorities(
                AuthorityUtils.
                        commaSeparatedStringToAuthorityList(
                                String.join(",",kKymenu)
                        )
        );

        /*登录进行日志的录入*/
        Klog klog = new Klog();
        klog.setLogintime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        klog.setUserip(request.getRemoteAddr());
        klog.setUsername(kKyuser.getUsername());
        try{
            klogService.insert(klog);
        }catch (Exception e){
            e.printStackTrace();
        }

        return kKyuser;
    }

    /**
     * 查询用户
     * @param kKyuser
     * @return
     */
    public DataJson listUser(KKyuser kKyuser){
        try{
            List<KKyuser> list = (List<KKyuser>) redisUtil.get("listUser:listUser"+kKyuser.getPage()+kKyuser.getLimit());
            Integer total = (Integer) redisUtil.get("listUser:total"+kKyuser.getPage()+kKyuser.getLimit());
            if(list==null){
                PageHelper.startPage(kKyuser.getPage(),kKyuser.getLimit());
                 list = kkyuserMapper.listUser(kKyuser);
                PageInfo info = new PageInfo(list);
                total = (int)info.getTotal();
                redisUtil.set("listUser:listUser"+kKyuser.getPage()+kKyuser.getLimit(),list);
                redisUtil.set("listUser:total"+kKyuser.getPage()+kKyuser.getLimit(),total);
            }
            return new DataJson(total,list);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 校科研管理消息处理
     * @param kKyuser
     * @return
     */
    public DataJson messagelistUser(KKyuser kKyuser){
            PageHelper.startPage(kKyuser.getPage(),kKyuser.getLimit());
            List<KKyuser> list = kkyuserMapper.messagelistUser(kKyuser);
            PageInfo info = new PageInfo(list);
            return new DataJson(info.getTotal(),list);
    }

    /**
     * 查询单个
     * @param kKyuser
     * @return
     */
    public DataJson listBy(KKyuser kKyuser){
        try{
                PageHelper.startPage(kKyuser.getPage(),kKyuser.getLimit());
            List<KKyuser> list = kkyuserMapper.listUser(kKyuser);
                PageInfo info = new PageInfo(list);
            return new DataJson(info.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public int addUser(KKyuser kKyuser){
        try {
            String pwd = passwordEncoder.encode(kKyuser.getPassword());
            kKyuser.setPassword(pwd);
            Set<String> keys = redisUtil.keys("listUser*");
            redisUtil.delkeys(keys);
           return kkyuserMapper.insert(kKyuser);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public int editUser(KKyuser kKyuser){
        try {
            String pwd = passwordEncoder.encode(kKyuser.getPassword());
            kKyuser.setPassword(pwd);
            Set<String> keys = redisUtil.keys("listUser*");
            redisUtil.delkeys(keys);
            return kkyuserMapper.updateByPrimaryKey(kKyuser);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public int delUser(Short kyid){
        try {
            Set<String> keys = redisUtil.keys("listUser*");
            redisUtil.delkeys(keys);
            kKyroleMapper.del_user_role(kyid);
            return kkyuserMapper.deleteByPrimaryKey(kyid);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public Short findUserRoleType(String username){
        return  kkyuserMapper.findUserRoleType(username);
    }

    public KKyuser selectByPrimaryName(String kyname){
        return kkyuserMapper.selectByPrimaryName(kyname);
    }

    /**
     * 修改个人信息
     * @param record
     * @return
     */
    public int updatePersonl(KKyuser record){
        try{
            return kkyuserMapper.updatePersonl(record);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public Short selectByuname(String kyname){
        return kkyuserMapper.selectByuname(kyname);
    }

    public String selectByPassword(Short kyid){
        return kkyuserMapper.selectByPassword(kyid);
    }

    /**
     * 修改密码
     * @param record
     * @return
     */
    public int updatePwd(KKyuser record){
        return kkyuserMapper.updatePwd(record);
    }
}
