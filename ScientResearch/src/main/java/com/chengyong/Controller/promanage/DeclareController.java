package com.chengyong.Controller.promanage;

import com.chengyong.entity.KPici;
import com.chengyong.entity.KProject;
import com.chengyong.entity.KProjectper;
import com.chengyong.service.KPiciService;
import com.chengyong.service.KProjectService;
import com.chengyong.service.KProjectperService;
import com.chengyong.util.DataJson;
import com.chengyong.util.ExportProjectUtils;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     *  系科研秘书查看项目信息
     * @param kProject
     * @return
     */
    @RequestMapping("/listProject")
    public DataJson listProject(KProject kProject){
        return kProjectService.listProject(kProject);
    }

    /**
     * 校 科研秘书查看项目信息
     * @param kProject
     * @return
     */
    @RequestMapping("/listProjectSchool")
    public DataJson listProjectSchool(KProject kProject){
        return kProjectService.listProjectSchool(kProject);
    }

    /**
     * 系科研秘书 搜索项目信息
     * @param kProject
     * @return
     */
    @RequestMapping("/seachrProject")
    public DataJson seachrProject(KProject kProject){
        return kProjectService.seachrProject(kProject);
    }


    /**
     * 校科研秘书 搜索项目信息
     * @param kProject
     * @return
     */
    @RequestMapping("/seachrProjectSch")
    public DataJson seachrProjectSch(KProject kProject){
        return kProjectService.seachrProjectSch(kProject);
    }

    /**
     * 校系 科研秘书修改项目信息
     * @param kProject
     * @return
     */
    @RequestMapping("/editproject")
    public Map<String,Object> editproject(KProject kProject){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPrimaryKeySelective(kProject)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    /**
     * 校系 科研秘书删除项目信息
     * @param pid
     * @return
     */
    @RequestMapping("/delproject")
    public Map<String,Object> delproject(@Param("pid") Short pid){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.deleteByPrimaryKey(pid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 校系科研秘书 删除多个项目信息
     * @param pids
     * @return
     */
    @RequestMapping("/delprojectlot")
    public Map<String,Object> delprojectlot(@Param("pids") Short[] pids){
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < pids.length; i++) {
            if(kProjectService.deleteByPrimaryKey(pids[i])>0){
                map.put("info", PUBLIC_ATTRIBUTE.DELETE);
            }else{
                map.put("info",PUBLIC_ATTRIBUTE.DELETE_ERROR);
            }
        }

        return map;
    }

    /**
     * 系科研秘书审核 项目信息
     * @param psb1
     * @return
     */
    @RequestMapping("/updateByPSB1")
    public Map<String,Object> updateByPSB1(@Param("pid") Short pid,@Param("psb1") Short psb1){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPSB1(pid,psb1)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研秘书审核 项目信息
     * @param psb2
     * @return
     */
    @RequestMapping("/updateByPSB2")
    public Map<String,Object> updateByPSB2(@Param("pid") Short pid,@Param("psb2") Short psb2){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPSB2(pid,psb2)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }


    /**
     * 系科研秘书立项
     * @param
     * @return
     */
    @RequestMapping("/updateByPLX1")
    public Map<String,Object> updateByPLX1(@Param("pid") Short pid,@Param("plx1") Short plx1){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPLX1(pid,plx1)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研秘书立项
     * @param
     * @return
     */
    @RequestMapping("/updateByPLX2")
    public Map<String,Object> updateByPLX2(@Param("pid") Short pid,@Param("plx2") Short plx2){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPLX2(pid,plx2)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }


    /**
     *  校科研秘书进行查看中检项目
     * @param kProject
     * @return
     */
    @RequestMapping("/checklistProject")
    public DataJson checklistProject(KProject kProject){
        return kProjectService.checklistProject(kProject);
    }

    /**
     *  系秘书进行查看中检项目
     * @param kProject
     * @return
     */
    @RequestMapping("/checklistProject2")
    public DataJson checklistProject2(KProject kProject){
        return kProjectService.checklistProject2(kProject);
    }

    /**
     *  科研人员进行查看中检项目
     * @param kProject
     * @return
     */
    @RequestMapping("/checklistProject3")
    public DataJson checklistProject3(KProject kProject){
        return kProjectService.checklistProject3(kProject);
    }

    /**
     *  校科研秘书进行查看结项
     * @param kProject
     * @return
     */
    @RequestMapping("/endlistProject1")
    public DataJson endlistProject1(KProject kProject){
        return kProjectService.endlistProject1(kProject);
    }

    /**
     *  系科研秘书进行查看结项
     * @param kProject
     * @return
     */
    @RequestMapping("/endlistProject2")
    public DataJson endlistProject2(KProject kProject){
        return kProjectService.endlistProject2(kProject);
    }

    /**
     * 系科研秘书完成中检
     * @param
     * @return
     */
    @RequestMapping("/updateByPZJ1")
    public Map<String,Object> updateByPZJ1(@Param("pid") Short pid,@Param("pzj1") Short pzj1){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPZJ1(pid,pzj1)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研秘书完成中检
     * @param
     * @return
     */
    @RequestMapping("/updateByPZJ2")
    public Map<String,Object> updateByPZJ2(@Param("pid") Short pid,@Param("pzj2") Short pzj2){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPZJ2(pid,pzj2)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }


    /**
     * 系科研秘书完成结项
     * @param
     * @return
     */
    @RequestMapping("/updateByPJX1")
    public Map<String,Object> updateByPJX1(@Param("pid") Short pid,@Param("pjx1") Short pjx1){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPJX1(pid,pjx1)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研秘书完成结项
     * @param
     * @return
     */
    @RequestMapping("/updateByPJX2")
    public Map<String,Object> updateByPJX2(@Param("pid") Short pid,@Param("pjx2") Short pjx2){
        Map<String,Object> map = new HashMap<>();
        if(kProjectService.updateByPJX2(pid,pjx2)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info",PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

}
