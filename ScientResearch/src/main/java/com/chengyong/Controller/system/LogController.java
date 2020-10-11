package com.chengyong.Controller.system;

import com.chengyong.entity.KKyuser;
import com.chengyong.entity.Klog;
import com.chengyong.service.KlogService;
import com.chengyong.util.DataJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private KlogService klogService;

    @RequestMapping("/listLog")
    public DataJson listLog(Klog klog){
        return klogService.listLog(klog);
    }

    @RequestMapping("/searchLog")
    @ResponseBody
    public DataJson searchLog(Klog klog){
        DataJson dataJson = klogService.listBy(klog);
        return dataJson;
    }
}
