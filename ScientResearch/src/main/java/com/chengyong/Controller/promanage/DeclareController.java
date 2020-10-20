package com.chengyong.Controller.promanage;

import com.chengyong.entity.KPici;
import com.chengyong.entity.KProject;
import com.chengyong.entity.KProjectper;
import com.chengyong.service.KPiciService;
import com.chengyong.service.KProjectService;
import com.chengyong.service.KProjectperService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/declare")
public class DeclareController {

    @Autowired
    private KPiciService kPiciService;

    @Autowired
    private KProjectService kProjectService;

    @Autowired
    private KProjectperService kProjectperService;

    @RequestMapping("/listdeclare")
    public DataJson listdeclare(KPici kPici){
        return kPiciService.listdeclare(kPici);
    }

    @RequestMapping("/searchdeclare")
    public DataJson searchdeclare(KPici kPici){
        return kPiciService.searchdeclare(kPici);
    }

    @RequestMapping("/adddeclare")
    public Map<String,Object> adddeclare(KPici kPici){
        Map<String,Object> map = new HashMap<>();
            if(kPiciService.insert(kPici)>0){
                map.put("info", PUBLIC_ATTRIBUTE.ADD);
            }else{
                map.put("info",PUBLIC_ATTRIBUTE.ADD_ERROR);
            }
            return map;
    }

    @RequestMapping("/editdeclare")
    public Map<String,Object> editdeclare(KPici kPici){
        Map<String,Object> map = new HashMap<>();
        if(kPiciService.updateByPrimaryKey(kPici)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    @RequestMapping("/deldeclare")
    public Map<String,Object> deldeclare(@Param("pcid") Short pcid){
        Map<String,Object> map = new HashMap<>();
        if(kPiciService.deleteByPrimaryKey(pcid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    @RequestMapping("/deldeclarelot")
    public Map<String,Object> deldeclarelot(@Param("pcid") Short[] pcid){
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < pcid.length; i++) {
            if(kPiciService.deldeclarelot(pcid[i])>0){
                map.put("info", PUBLIC_ATTRIBUTE.DELETE);
            }else{
                map.put("info",PUBLIC_ATTRIBUTE.DELETE_ERROR);
            }
        }

        return map;
    }


    /**
     * 科研人员添加的项目信息
     * @param kProject
     * @return
     */
    @RequestMapping("/addProject")
    public Map<String,Object> addProject(KProject kProject){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.insert(kProject)>0){
            KProject kProject1 = kProjectService.selectByPnameAndPPEOPLE(kProject);
            map.put("info", kProject1.getPid());
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 添加科研项目所需成员人
     * @param kProjectper
     * @return
     */
    @RequestMapping("/addProjecter")
    public Map<String,Object> addProjecter(KProjectper kProjectper){
        Map<String,Object> map = new HashMap<>();
        if(kProjectperService.insert(kProjectper)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

}
