package com.chengyong.Controller.echart;

import com.chengyong.entity.KThesis;
import com.chengyong.service.KPatentService;
import com.chengyong.service.KProresultsService;
import com.chengyong.service.KThesisService;
import com.chengyong.service.KWorkService;
import com.chengyong.util.DataJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/echart")
public class EchartController {

    @Autowired
    private KThesisService kThesisService;

    @Autowired
    private KWorkService kWorkService;

    @Autowired
    private KProresultsService kProresultsService;

    @Autowired
    private KPatentService kPatentService;

    @RequestMapping("/echartPersonal3")
    public List<Integer> echartPersonal(String startyear, String endyear){
        List<Integer> list = new ArrayList<>();
        Integer countKTHESIS = kThesisService.countKTHESIS(startyear,endyear);
        Integer countKWork = kWorkService.countKWork(startyear, endyear);
        Integer countKPRORESULTS = kProresultsService.countKPRORESULTS(startyear, endyear);
        Integer countKPATENT = kPatentService.countKPATENT(startyear, endyear);
        list.add(countKTHESIS);
        list.add(countKWork);
        list.add(countKPRORESULTS);
        list.add(countKPATENT);
        return list;
    }

    @RequestMapping("/echartPersonal2")
    public List<Integer> echartPersonal2(String startyear, String endyear){
        List<Integer> list = new ArrayList<>();
        Integer countKTHESIS = kThesisService.countKTHESISdept(startyear,endyear);
        Integer countKWork = kWorkService.countKWorkdept(startyear, endyear);
        Integer countKPRORESULTS = kProresultsService.countKPRORESULTSdept(startyear, endyear);
        Integer countKPATENT = kPatentService.countKPATENTdept(startyear, endyear);
        list.add(countKTHESIS);
        list.add(countKWork);
        list.add(countKPRORESULTS);
        list.add(countKPATENT);
        return list;
    }

    @RequestMapping("/echartPersonal1")
    public List<Integer> echartPersonal1(String startyear, String endyear){
        List<Integer> list = new ArrayList<>();
        Integer countKTHESIS = kThesisService.countKTHESISsch(startyear,endyear);
        Integer countKWork = kWorkService.countKWorksch(startyear, endyear);
        Integer countKPRORESULTS = kProresultsService.countKPRORESULTSsch(startyear, endyear);
        Integer countKPATENT = kPatentService.countKPATENTsch(startyear, endyear);
        list.add(countKTHESIS);
        list.add(countKWork);
        list.add(countKPRORESULTS);
        list.add(countKPATENT);
        return list;
    }

}
