package com.chengyong.Controller.promanage;

import com.chengyong.entity.KProject;
import com.chengyong.service.KProjectService;
import com.chengyong.util.DataJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/termin")
public class TerminController {

    @Autowired
    private KProjectService kProjectService;

    /**
     *  校科研项目终止查看
     * @param
     * @return
     */
    @RequestMapping("/terminlistProject1")
    public DataJson terminlistProject1(KProject kProject){
        return kProjectService.terminlistProject1(kProject);
    }

    /**
     *  系科研项目终止查看
     * @param
     * @return
     */
    @RequestMapping("/terminlistProject2")
    public DataJson terminlistProject2(KProject kProject){
        return kProjectService.terminlistProject2(kProject);
    }

    /**
     *  科研人员项目终止查看
     * @param
     * @return
     */
    @RequestMapping("/terminlistProject3")
    public DataJson terminlistProject3(KProject kProject){
        return kProjectService.terminlistProject3(kProject);
    }
}
