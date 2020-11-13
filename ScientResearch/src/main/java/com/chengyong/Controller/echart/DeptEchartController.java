package com.chengyong.Controller.echart;

import com.chengyong.service.KPatentService;
import com.chengyong.service.KProresultsService;
import com.chengyong.service.KThesisService;
import com.chengyong.service.KWorkService;
import com.chengyong.util.YEAR_THERE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deptEchart")
public class DeptEchartController {

    @Autowired
    private KWorkService kWorkService;
    @Autowired
    private KThesisService kThesisService;
    @Autowired
    private KProresultsService kProresultsService;
    @Autowired
    private KPatentService kPatentService;

    @RequestMapping("/deptechart")
    public List<Map<String,Object>> thereechart3(String startdate){

        Map<String,Object> mapth = new LinkedHashMap<String,Object>();
        Map<String,Object> mapwork = new LinkedHashMap<String,Object>();
        Map<String,Object> mappro = new LinkedHashMap<String,Object>();
        Map<String,Object> mappaten = new LinkedHashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<>();

        String manag = "管理系";
        String infor = "信息系";
        String civil = "土木系";


        mapth.put("product","论文");
        mapth.put(manag,kThesisService.deptcountKthesis(startdate,manag));
        mapth.put(infor,kThesisService.deptcountKthesis(startdate,infor));
        mapth.put(civil,kThesisService.deptcountKthesis(startdate,civil));

        mapwork.put("product","著作");
        mapwork.put(manag,kWorkService.deptcountKWork(startdate,manag));
        mapwork.put(infor,kWorkService.deptcountKWork(startdate,infor));
        mapwork.put(civil,kWorkService.deptcountKWork(startdate,civil));

        mappro.put("product","项目");
        mappro.put(manag,kProresultsService.deptcountKprojectresult(startdate,manag));
        mappro.put(infor,kProresultsService.deptcountKprojectresult(startdate,infor));
        mappro.put(civil,kProresultsService.deptcountKprojectresult(startdate,civil));

        mappaten.put("product","专利");
        mappaten.put(manag,kPatentService.deptcountKPatent(startdate,manag));
        mappaten.put(infor,kPatentService.deptcountKPatent(startdate,infor));
        mappaten.put(civil,kPatentService.deptcountKPatent(startdate,civil));

        list.add(mapth);
        list.add(mapwork);
        list.add(mappro);
        list.add(mappaten);
        return list;
    }

}
