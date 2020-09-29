package com.chengyong.Controller.system;

import com.chengyong.entity.Ktreenode;
import com.chengyong.service.KtreenodeService;
import com.chengyong.util.DataTree;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class menu {
    @Autowired
    private KtreenodeService ktreenodeService;

    /**
     * 菜单数据
     * @return
     */
    @RequestMapping("/menudata")
    @ResponseBody
    public DataTree menudata(){
        DataTree dataTree = ktreenodeService.listTreeNode();
        return dataTree;
    }

    /**
     * 菜单数据修改
     * @return
     */
    @RequestMapping("/menuedit")
    @ResponseBody
    public Map<String,Object> menuedit(Ktreenode ktreenode){
        Map<String,Object> map = new HashMap<>();
        try{
            ktreenodeService.updateByPrimaryKeySelective(ktreenode);
            map.put("msg", PUBLIC_ATTRIBUTE.UPDATE);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
            return map;
        }
    }

    @RequestMapping("/menudel")
    @ResponseBody
    public Map<String,Object> menudel(@Param("treenodeid") Short treenodeid){
        Map<String,Object> map = new HashMap<String,Object>();
            String result = ktreenodeService.deleteByPrimaryKey(treenodeid);
            map.put("msg",result);
        return  map;
    }
}
