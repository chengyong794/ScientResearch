package com.chengyong.Controller.compre;

import com.chengyong.entity.KInfo;
import com.chengyong.entity.KKyuser;
import com.chengyong.entity.Kfunding;
import com.chengyong.service.KInfoService;
import com.chengyong.service.KKyuserService;
import com.chengyong.util.DataJson;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private KKyuserService kKyuserService;

    @Autowired
    private KInfoService kInfoService;

    @RequestMapping("/messagelistUser")
    @ResponseBody
    public DataJson messagelistUser(KKyuser kKyuser){
        DataJson dataJson = kKyuserService.messagelistUser(kKyuser);
        return dataJson;
    }

    @RequestMapping("/messagelist3")
    @ResponseBody
    public DataJson messagelist3(KInfo kInfo){
        DataJson dataJson = kInfoService.MessageList(kInfo);
        return dataJson;
    }

    /**
     * 消息的添加
     * @return
     */
    @RequestMapping("/messageadd")
    @ResponseBody
    public Map<String,Object> messageadd(
            @Param("outperson") String outperson,
            @Param("kyid") Short kyid,
            @Param("icontext") String icontext,
            @Param("infotime") String infotime
    ){
        KInfo kInfo = new KInfo();
        kInfo.setOutperson(outperson);
        kInfo.setIcontext(icontext);
        kInfo.setInfotime(infotime);
        Map<String,Object> map = new HashMap<>();
        if(kInfoService.insert(kInfo,kyid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.SEND_SUCCESS);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.SEND_ERROR);
        }
        return map;
    }

    /**
     * 消息的批量添加
     * @return
     */
    @RequestMapping("/messagelowadd")
    @ResponseBody
    public Map<String,Object> messagelowadd(
            @Param("outperson") String outperson,
            @Param("kyids") Short[] kyids,
            @Param("icontext") String icontext,
            @Param("infotime") String infotime
    ){
        Map<String,Object> map = new HashMap<>();
        if(kyids==null ||kyids.length==0){
            map.put("info", PUBLIC_ATTRIBUTE.SEND_PERSON);
        }else{
            KInfo kInfo = new KInfo();
            kInfo.setOutperson(outperson);
            kInfo.setIcontext(icontext);
            kInfo.setInfotime(infotime);
            if(kInfoService.insertlow(kInfo,kyids)>0){
                map.put("info", PUBLIC_ATTRIBUTE.SEND_SUCCESS);
            }else{
                map.put("info", PUBLIC_ATTRIBUTE.SEND_ERROR);
            }
        }
        return map;
    }

    /**
     * 消息删除
     * @return
     */
    @RequestMapping("/messagedel")
    @ResponseBody
    public Map<String,Object> messagedel(Short iid){
        Map<String,Object> map = new HashMap<>();
        if(kInfoService.deleteByPrimaryKey(iid)>0){
            map.put("info", PUBLIC_ATTRIBUTE.DELETE);
        }else{
            map.put("info", PUBLIC_ATTRIBUTE.DELETE_ERROR);
        }
        return map;
    }
}
