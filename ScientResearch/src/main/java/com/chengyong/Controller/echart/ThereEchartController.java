package com.chengyong.Controller.echart;

import com.chengyong.service.KPatentService;
import com.chengyong.service.KProresultsService;
import com.chengyong.service.KThesisService;
import com.chengyong.service.KWorkService;
import com.chengyong.util.YEAR_THERE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/thereEchart")
public class ThereEchartController {
    @Autowired
    private KWorkService kWorkService;
    @Autowired
    private KThesisService kThesisService;
    @Autowired
    private KProresultsService kProresultsService;
    @Autowired
    private KPatentService kPatentService;

    @RequestMapping("/thereechart3")
    public List<Map<String,Object>> thereechart3(){

        Map<String,Object> mapth = new LinkedHashMap<String,Object>();
        Map<String,Object> mapwork = new LinkedHashMap<String,Object>();
        Map<String,Object> mappro = new LinkedHashMap<String,Object>();
        Map<String,Object> mappaten = new LinkedHashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<>();

        String time1 = YEAR_THERE.year(0);
        String time2 = YEAR_THERE.year(-1);
        String time3 = YEAR_THERE.year(-2);

        mapth.put("product","论文");
        mapth.put(time1,kThesisService.therecountKthesis(time1));
        mapth.put(time2,kThesisService.therecountKthesis(time2));
        mapth.put(time3,kThesisService.therecountKthesis(time3));

        mapwork.put("product","著作");
        mapwork.put(time1,kWorkService.therecountKWork(time1));
        mapwork.put(time2,kWorkService.therecountKWork(time2));
        mapwork.put(time3,kWorkService.therecountKWork(time3));

        mappro.put("product","项目");
        mappro.put(time1,kProresultsService.therecountKprojectresult(time1));
        mappro.put(time2,kProresultsService.therecountKprojectresult(time2));
        mappro.put(time3,kProresultsService.therecountKprojectresult(time3));

        mappaten.put("product","专利");
        mappaten.put(time1,kPatentService.therecountKPatent(time1));
        mappaten.put(time2,kPatentService.therecountKPatent(time2));
        mappaten.put(time3,kPatentService.therecountKPatent(time3));

        list.add(mapth);
        list.add(mapwork);
        list.add(mappro);
        list.add(mappaten);
        return list;
    }

    @RequestMapping("/thereechart2")
    public List<Map<String,Object>> thereechart2(){

        Map<String,Object> mapth = new LinkedHashMap<String,Object>();
        Map<String,Object> mapwork = new LinkedHashMap<String,Object>();
        Map<String,Object> mappro = new LinkedHashMap<String,Object>();
        Map<String,Object> mappaten = new LinkedHashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<>();

        String time1 = YEAR_THERE.year(0);
        String time2 = YEAR_THERE.year(-1);
        String time3 = YEAR_THERE.year(-2);

        mapth.put("product","论文");
        mapth.put(time1,kThesisService.therecountKthesis2(time1));
        mapth.put(time2,kThesisService.therecountKthesis2(time2));
        mapth.put(time3,kThesisService.therecountKthesis2(time3));

        mapwork.put("product","著作");
        mapwork.put(time1,kWorkService.therecountKWork2(time1));
        mapwork.put(time2,kWorkService.therecountKWork2(time2));
        mapwork.put(time3,kWorkService.therecountKWork2(time3));

        mappro.put("product","项目");
        mappro.put(time1,kProresultsService.therecountKprojectresult2(time1));
        mappro.put(time2,kProresultsService.therecountKprojectresult2(time2));
        mappro.put(time3,kProresultsService.therecountKprojectresult2(time3));

        mappaten.put("product","专利");
        mappaten.put(time1,kPatentService.therecountKPatent2(time1));
        mappaten.put(time2,kPatentService.therecountKPatent2(time2));
        mappaten.put(time3,kPatentService.therecountKPatent2(time3));

        list.add(mapth);
        list.add(mapwork);
        list.add(mappro);
        list.add(mappaten);
        return list;
    }

    @RequestMapping("/thereechart1")
    public List<Map<String,Object>> thereechart1(){

        Map<String,Object> mapth = new LinkedHashMap<String,Object>();
        Map<String,Object> mapwork = new LinkedHashMap<String,Object>();
        Map<String,Object> mappro = new LinkedHashMap<String,Object>();
        Map<String,Object> mappaten = new LinkedHashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<>();

        String time1 = YEAR_THERE.year(0);
        String time2 = YEAR_THERE.year(-1);
        String time3 = YEAR_THERE.year(-2);

        mapth.put("product","论文");
        mapth.put(time1,kThesisService.therecountKthesis1(time1));
        mapth.put(time2,kThesisService.therecountKthesis1(time2));
        mapth.put(time3,kThesisService.therecountKthesis1(time3));

        mapwork.put("product","著作");
        mapwork.put(time1,kWorkService.therecountKWork1(time1));
        mapwork.put(time2,kWorkService.therecountKWork1(time2));
        mapwork.put(time3,kWorkService.therecountKWork1(time3));

        mappro.put("product","项目");
        mappro.put(time1,kProresultsService.therecountKprojectresult1(time1));
        mappro.put(time2,kProresultsService.therecountKprojectresult1(time2));
        mappro.put(time3,kProresultsService.therecountKprojectresult1(time3));

        mappaten.put("product","专利");
        mappaten.put(time1,kPatentService.therecountKPatent1(time1));
        mappaten.put(time2,kPatentService.therecountKPatent1(time2));
        mappaten.put(time3,kPatentService.therecountKPatent1(time3));

        list.add(mapth);
        list.add(mapwork);
        list.add(mappro);
        list.add(mappaten);
        return list;
    }
}
