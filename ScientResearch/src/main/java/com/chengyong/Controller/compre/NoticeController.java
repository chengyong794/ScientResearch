package com.chengyong.Controller.compre;

import com.chengyong.entity.KInfo;
import com.chengyong.entity.KNotice;
import com.chengyong.entity.KWork;
import com.chengyong.service.KNoticeService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private KNoticeService kNoticeService;

    @RequestMapping("/ListNotice")
    public DataJson ListNotice(KNotice kNotice){
        DataJson dataJson = kNoticeService.ListNotice(kNotice);
        return dataJson;
    }

    /**
     * 公告添加
     * @return
     */
    @RequestMapping("/noticeadd")
    public Map<String,Object> noticeadd(KNotice kNotice){
        Map<String,Object> map = new HashMap<>();
        if(kNoticeService.insert(kNotice)>0){
            map.put("info", PUBLIC_ATTRIBUTE.ADD);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.ADD_ERROR);
        }
        return map;
    }

    /**
     * 公告修改
     * @return
     */
    @RequestMapping("/noticeedit")
    public Map<String,Object> noticeedit(KNotice kNotice){
        Map<String,Object> map = new HashMap<>();
        if(kNoticeService.updateByPrimaryKey(kNotice)>0){
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.UPDATE_ERROR);
        }
        return map;
    }

    /**
     * 公告删除
     * @return
     */
    @RequestMapping("/noticedel")
    public Map<String,Object> noticedel(Short nid){
        Map<String,Object> map = new HashMap<>();
        if(kNoticeService.deleteByPrimaryKey(nid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

    /**
     * 公告批量删除
     * @return
     */
    @RequestMapping("/noticedellow")
    public Map<String,Object> noticedellow(Short[] nids){
        Map<String,Object> map = new HashMap<>();
        if(kNoticeService.deleteByPrimaryKeylow(nids)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }

}
