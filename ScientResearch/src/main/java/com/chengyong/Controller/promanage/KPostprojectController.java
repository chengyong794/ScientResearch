package com.chengyong.Controller.promanage;

import com.chengyong.entity.KPostproject;
import com.chengyong.service.KPostprojectService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/KPostproject")
public class KPostprojectController {

    @Autowired
    private KPostprojectService kPostprojectService;


    /**
     * 校科研管理查看结项信息
     */
    @RequestMapping("/K_POSTPROJECTlist1")
    public DataJson K_POSTPROJECTlist1(KPostproject kPostproject){
        return  kPostprojectService.K_POSTPROJECTlist1(kPostproject);
    }

    /**
     * 系科研管理审核通过
     * @return
     */
    @RequestMapping("/updateByPPSTATE1")
    public Map<String,Object> updateByPPSTATE1(Short ppid, Short ppstate1,Short pid){
        Map<String,Object> map = new HashMap<>();

        if(kPostprojectService.updateByPPSTATE1(ppid,ppstate1,pid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研管理审核通过
     * @return
     */
    @RequestMapping("/updateByPPSTATE2")
    public Map<String,Object> updateByPPSTATE2(Short ppid, Short ppstate2,Short pid){
        Map<String,Object> map = new HashMap<>();

        if(kPostprojectService.updateByPPSTATE2(ppid,ppstate2,pid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 科研人员结项信息添加
     * @return
     */
    @RequestMapping("/KPostprojectadd")
    public Map<String,Object> KPostprojectadd(KPostproject kPostproject){
        Map<String,Object> map = new HashMap<>();

        if(kPostprojectService.insert(kPostproject)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }
}
