package com.chengyong.Controller.compre;

import com.chengyong.entity.KDelayproject;
import com.chengyong.entity.KProject;
import com.chengyong.entity.Kfunding;
import com.chengyong.service.KfundingService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/compre")
public class CompreController {

    @Autowired
    private KfundingService kfundingService;

    /**
     * 校 查看经费
     * @param kfunding
     * @return
     */
    @RequestMapping("/FundingList")
    public DataJson FundingList(Kfunding kfunding){

        return kfundingService.FundingList(kfunding);
    }

    /**
     * 科研人员查看分配经费
     * @param kfunding
     * @return
     */
    @RequestMapping("/FundingListBykyID")
    public DataJson FundingListBykyID(Kfunding kfunding){

        return kfundingService.FundingListBykyID(kfunding);
    }

    /**
     * 科研人员经费预算信息添加
     * @return
     */
    @RequestMapping("/fundingadd")
    public Map<String,Object> fundingadd(Kfunding kfunding){
        Map<String,Object> map = new HashMap<>();
        if(kfundingService.insert(kfunding)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 校科研管理分配经费
     * @param kfunding
     * @return
     */
    @RequestMapping("/editfunding")
    public Map<String,Object> editfunding(Kfunding kfunding){
        Map<String,Object> map = new HashMap<>();
       int k = kfundingService.updateByPrimaryKey(kfunding);
        if(k == 2){
            map.put("info", PUBLIC_ATTRIBUTE.DISTRIBUTION_insufficient);
        }else if(k>0){
            map.put("info", PUBLIC_ATTRIBUTE.DISTRIBUTION);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.DISTRIBUTION_ERROR);
        }
        return map;
    }

}
