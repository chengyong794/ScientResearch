package com.chengyong.Controller.results;

import com.chengyong.entity.KPatent;
import com.chengyong.entity.KProresults;
import com.chengyong.service.KPatentService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    private KPatentService kPatentService;

    /**
     *  科研人员查看专利
     * @param
     * @return
     */
    @RequestMapping("/patentlist3")
    public DataJson patentlist3(KPatent kPatent){

        return kPatentService.patentlist3(kPatent);
    }

    /**
     *  系科研管理查看专利
     * @param
     * @return
     */
    @RequestMapping("/patentlist2")
    public DataJson patentlist2(KPatent kPatent){
        return kPatentService.patentlist2(kPatent);
    }

    /**
     *  校科研管理查看专利
     * @param
     * @return
     */
    @RequestMapping("/patentlist1")
    public DataJson patentlist1(KPatent kPatent){

        return kPatentService.patentlist1(kPatent);
    }

    /**
     * 科研人员专利添加
     * @return
     */
    @RequestMapping("/patentResultadd")
    public Map<String,Object> patentResultadd(KPatent kPatent){
        Map<String,Object> map = new HashMap<>();
        if(kPatentService.insert(kPatent)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 科研人员专利修改
     * @return
     */
    @RequestMapping("/patentResultedit")
    public Map<String,Object> patentResultedit(KPatent kPatent){
        Map<String,Object> map = new HashMap<>();
        if(kPatentService.updateByPrimaryKey(kPatent)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员专利删除
     * @return
     */
    @RequestMapping("/patentResultdel")
    public Map<String,Object> patentResultdel(Short zid){
        Map<String,Object> map = new HashMap<>();
        if(kPatentService.deleteByPrimaryKey(zid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员专利批量删除
     * @return
     */
    @RequestMapping("/patentResultdellow")
    public Map<String,Object> patentResultdellow(Short[] zids){
        Map<String,Object> map = new HashMap<>();
        if(kPatentService.deleteByPrimaryKeylow(zids)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 系科研审核专利
     * @return
     */
    @RequestMapping("/updateByZACHNUM2")
    public Map<String,Object> updateByZACHNUM2(Short zid, Short zachnum){
        Map<String,Object> map = new HashMap<>();
        if(kPatentService.updateByZACHNUM2(zid,zachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研审核专利
     * @return
     */
    @RequestMapping("/updateByZACHNUM1")
    public Map<String,Object> updateByZACHNUM1(Short zid, Short zachnum){
        Map<String,Object> map = new HashMap<>();
        if(kPatentService.updateByZACHNUM1(zid,zachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }
}
