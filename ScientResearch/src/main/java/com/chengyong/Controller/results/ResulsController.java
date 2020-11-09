package com.chengyong.Controller.results;

import com.chengyong.entity.KProject;
import com.chengyong.entity.KThesis;
import com.chengyong.service.KThesisService;
import com.chengyong.util.DataJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
