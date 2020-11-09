package com.chengyong.Controller.results;

import com.chengyong.entity.KDelayproject;
import com.chengyong.entity.KProject;
import com.chengyong.entity.KThesis;
import com.chengyong.service.KThesisService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/results")
public class ResulsController {

    @Autowired
    private KThesisService kThesisService;

    /**
     *  科研人员查看论文
     * @param
     * @return
     */
    @RequestMapping("/thesislistResult3")
    public DataJson thesislistResult3(KThesis kThesis){
        return kThesisService.thesislistResult3(kThesis);
    }

    /**
     *  系科研管理查看论文
     * @param
     * @return
     */
    @RequestMapping("/thesislistResult2")
    public DataJson thesislistResult2(KThesis kThesis){
        return kThesisService.thesislistResult2(kThesis);
    }

    /**
     *  校科研管理查看论文
     * @param
     * @return
     */
    @RequestMapping("/thesislistResult1")
    public DataJson thesislistResult1(KThesis kThesis){
        return kThesisService.thesislistResult1(kThesis);
    }

    /**
     * 科研人员论文添加
     * @return
     */
    @RequestMapping("/thesisResultadd")
    public Map<String,Object> thesisResultadd(KThesis kThesis){
        Map<String,Object> map = new HashMap<>();
        if(kThesisService.insert(kThesis)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 科研人员论文修改
     * @return
     */
    @RequestMapping("/thesisResultedit")
    public Map<String,Object> thesisResultedit(KThesis kThesis){
        Map<String,Object> map = new HashMap<>();
        if(kThesisService.updateByPrimaryKey(kThesis)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员论文删除
     * @return
     */
    @RequestMapping("/thesisResultdel")
    public Map<String,Object> thesisResultdel(Short tid){
        Map<String,Object> map = new HashMap<>();
        if(kThesisService.deleteByPrimaryKey(tid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员论文批量删除
     * @return
     */
    @RequestMapping("/thesisResultdellow")
    public Map<String,Object> thesisResultdellow(Short[] tids){
        Map<String,Object> map = new HashMap<>();
        if(kThesisService.deleteByPrimaryKeylow(tids)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 系科研管理审核论文
     * @return
     */
    @RequestMapping("/updateBytachnum2")
    public Map<String,Object> updateBytachnum2(Short tid,Short tachnum){
        Map<String,Object> map = new HashMap<>();
        if(kThesisService.updateBytachnum2(tid, tachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研管理审核论文
     * @return
     */
    @RequestMapping("/updateBytachnum1")
    public Map<String,Object> updateBytachnum1(Short tid,Short tachnum){
        Map<String,Object> map = new HashMap<>();
        if(kThesisService.updateBytachnum1(tid, tachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

}
