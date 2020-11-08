package com.chengyong.Controller.promanage;

import com.chengyong.entity.KDelayproject;
import com.chengyong.entity.KPostproject;
import com.chengyong.entity.KProject;
import com.chengyong.service.KDelayprojectService;
import com.chengyong.service.KProjectService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/delay")
public class DelayController {

    @Autowired
    private KProjectService kProjectService;

    @Autowired
    private KDelayprojectService kDelayprojectService;
    /**
     *  科研人员查看项目信息进行延期
     * @param kProject
     * @return
     */
    @RequestMapping("/delaylistProject3")
    public DataJson checklistProject3(KProject kProject){
        return kProjectService.delaylistProject3(kProject);
    }


    /**
     *  校科研管理查看延期信息
     * @param
     * @return
     */
    @RequestMapping("/delaylistProject1")
    public DataJson delaylistProject1(KDelayproject kDelayproject){
        return kDelayprojectService.delaylistProject1(kDelayproject);
    }

    /**
     *  系科研管理查看延期信息
     * @param
     * @return
     */
    @RequestMapping("/delaylistProject2")
    public DataJson delaylistProject2(KDelayproject kDelayproject){
        return kDelayprojectService.delaylistProject2(kDelayproject);
    }


    /**
     * 科研人员延期信息添加
     * @return
     */
    @RequestMapping("/delayprojectadd")
    public Map<String,Object> delayprojectadd(KDelayproject kDelayproject, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        kDelayproject.setPsource((String) request.getSession().getAttribute("delay_path"));
        if(kDelayprojectService.insert(kDelayproject)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 校科研审核项目延期
     * @return
     */
    @RequestMapping("/updateByPYQ1")
    public Map<String,Object> updateByPYQ1(Short pyq1,Short pdelayid,Short pid){
        Map<String,Object> map = new HashMap<>();
        if(kDelayprojectService.updateByPYQ1(pyq1, pdelayid,pid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 系科研审核项目延期
     * @return
     */
    @RequestMapping("/updateByPYQ2")
    public Map<String,Object> updateByPYQ2(Short pyq2,Short pdelayid,Short pid){
        Map<String,Object> map = new HashMap<>();
        if(kDelayprojectService.updateByPYQ2(pyq2, pdelayid,pid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 项目延期结束
     * @return
     */
    @RequestMapping("/PYQEND")
    public Map<String,Object> PYQEND(Short pid,Short pyq){
        Map<String,Object> map = new HashMap<>();
        if(kDelayprojectService.PYQEND(pyq, pid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }
}
