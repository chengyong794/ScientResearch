package com.chengyong.Controller.results;

import com.chengyong.entity.KThesis;
import com.chengyong.entity.KWork;
import com.chengyong.service.KWorkService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private KWorkService kWorkService;

    /**
     *  科研人员查看著作
     * @param
     * @return
     */
    @RequestMapping("/booklistResult3")
    public DataJson booklistResult3(KWork kWork){
        return kWorkService.booklistResult3(kWork);
    }

    /**
     *  系科研管理查看著作
     * @param
     * @return
     */
    @RequestMapping("/booklistResult2")
    public DataJson booklistResult2(KWork kWork){
        return kWorkService.booklistResult2(kWork);
    }

    /**
     *  校科研管理查看著作
     * @param
     * @return
     */
    @RequestMapping("/booklistResult1")
    public DataJson booklistResult1(KWork kWork){
        return kWorkService.booklistResult1(kWork);
    }

    /**
     * 科研人员著作添加
     * @return
     */
    @RequestMapping("/bookResultadd")
    public Map<String,Object> bookResultadd(KWork kWork){
        Map<String,Object> map = new HashMap<>();
        if(kWorkService.insert(kWork)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 科研人员著作修改
     * @return
     */
    @RequestMapping("/bookResultedit")
    public Map<String,Object> bookResultedit(KWork kWork){
        Map<String,Object> map = new HashMap<>();
        if(kWorkService.updateByPrimaryKey(kWork)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员著作删除
     * @return
     */
    @RequestMapping("/bookResultdel")
    public Map<String,Object> bookResultdel(Short wid){
        Map<String,Object> map = new HashMap<>();
        if(kWorkService.deleteByPrimaryKey(wid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 科研人员著作批量删除
     * @return
     */
    @RequestMapping("/bookResultdellow")
    public Map<String,Object> bookResultdellow(Short[] wids){
        Map<String,Object> map = new HashMap<>();
        if(kWorkService.deleteByPrimaryKeylow(wids)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 系科研审核著作
     * @return
     */
    @RequestMapping("/updateByWACHNUM2")
    public Map<String,Object> updateByWACHNUM2(Short wid,Short wachnum){
        Map<String,Object> map = new HashMap<>();
        if(kWorkService.updateByWACHNUM2(wid,wachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

    /**
     * 校科研审核著作
     * @return
     */
    @RequestMapping("/updateByWACHNUM1")
    public Map<String,Object> updateByWACHNUM1(Short wid,Short wachnum){
        Map<String,Object> map = new HashMap<>();
        if(kWorkService.updateByWACHNUM1(wid,wachnum)>0){
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.APPROVED_ERROR);
        }
        return map;
    }

}
