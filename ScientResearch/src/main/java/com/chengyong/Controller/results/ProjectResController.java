package com.chengyong.Controller.results;

import com.chengyong.entity.KProresults;
import com.chengyong.entity.KWork;
import com.chengyong.service.KProresultsService;
import com.chengyong.service.KWorkService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/projectResult")
public class ProjectResController {
    @Autowired
    private KProresultsService kProresultsService;

    /**
     *  科研人员查看项目成果
     * @param
     * @return
     */
    @RequestMapping("/KProresultlist3")
    public DataJson KProresultlist3(KProresults kProresults){
        return kProresultsService.KProresultlist3(kProresults);
    }

    /**
     *  系科研管理查看项目成果
     * @param
     * @return
     */
    @RequestMapping("/KProresultlist2")
    public DataJson KProresultlist2(KProresults kProresults){
        return kProresultsService.KProresultlist2(kProresults);
    }

    /**
     *  校科研管理查看项目成果
     * @param
     * @return
     */
    @RequestMapping("/KProresultlist1")
    public DataJson KProresultlist1(KProresults kProresults){
        return kProresultsService.KProresultlist1(kProresults);
    }

    /**
     * 科研人员项目成果添加
     * @return
     */
    @RequestMapping("/prokectresResultadd")
    public Map<String,Object> prokectresResultadd(KProresults kProresults){
        Map<String,Object> map = new HashMap<>();
        if(kProresultsService.insert(kProresults)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 科研人员项目成果修改
     * @return
     */
    @RequestMapping("/prokectresResultedit")
    public Map<String,Object> prokectresResultedit(KProresults kProresults){
        Map<String,Object> map = new HashMap<>();
        if(kProresultsService.updateByPrimaryKey(kProresults)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员项目成果删除
     * @return
     */
    @RequestMapping("/prokectresResultdel")
    public Map<String,Object> prokectresResultdel(Short prid){
        Map<String,Object> map = new HashMap<>();
        if(kProresultsService.deleteByPrimaryKey(prid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员项目成果批量删除
     * @return
     */
    @RequestMapping("/prokectresResultdellow")
    public Map<String,Object> prokectresResultdellow(Short[] prids){
        Map<String,Object> map = new HashMap<>();
        if(kProresultsService.deleteByPrimaryKeylow(prids)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 系科研审核项目
     * @return
     */
    @RequestMapping("/updateByPRACHNUM2")
    public Map<String,Object> updateByPRACHNUM2(Short prid, Short prachnum){
        Map<String,Object> map = new HashMap<>();
        if(kProresultsService.updateByPRACHNUM2(prid,prachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研审核项目
     * @return
     */
    @RequestMapping("/updateByPRACHNUM1")
    public Map<String,Object> updateByPRACHNUM1(Short prid, Short prachnum){
        Map<String,Object> map = new HashMap<>();
        if(kProresultsService.updateByPRACHNUM1(prid,prachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

}
