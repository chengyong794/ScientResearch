package com.chengyong.service.impl;

import com.chengyong.entity.KProresults;
import com.chengyong.entity.KThesis;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KProresultsMapper;
import com.chengyong.service.KProresultsService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KProresultsServiceImpl implements KProresultsService {

    @Autowired
    private KProresultsMapper kProresultsMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Override
    public int deleteByPrimaryKey(Short prid) {
        return kProresultsMapper.deleteByPrimaryKey(prid);
    }

    @Override
    public int deleteByPrimaryKeylow(Short[] prids) {
        try{
            for (Short prid:prids
            ) {
                kProresultsMapper.deleteByPrimaryKey(prid);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insert(KProresults record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setPresource((String) request.getSession().getAttribute("proresult_path"));
        return kProresultsMapper.insert(record);
    }

    @Override
    public int insertSelective(KProresults record) {
        return 0;
    }

    @Override
    public KProresults selectByPrimaryKey(Short prid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KProresults record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KProresults record) {
        String path = (String) request.getSession().getAttribute("proresult_path");
        if(path==null){
            return kProresultsMapper.updateByPrimaryKey1(record);
        }else{
            record.setPresource(path);
            return kProresultsMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    public DataJson KProresultlist3(KProresults record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KProresults> list  = kProresultsMapper.KProresultlist3(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson KProresultlist2(KProresults record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setDept(kKyuserMapper.selectByDept(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KProresults> list  = kProresultsMapper.KProresultlist2(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson KProresultlist1(KProresults record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KProresults> list  = kProresultsMapper.KProresultlist1(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByPRACHNUM2(Short prid, Short prachnum) {
        if(kProresultsMapper.selectByPRACHNUM(prid)==2){
            return 1;
        }else{
            return kProresultsMapper.updateByPRACHNUM2(prid,prachnum);
        }
    }

    @Override
    public int updateByPRACHNUM1(Short prid, Short prachnum) {
        return kProresultsMapper.updateByPRACHNUM1(prid,prachnum);
    }

    @Override
    public String selectByPATH(Short prid) {
        return kProresultsMapper.selectByPATH(prid);
    }

    @Override
    public Integer countKPRORESULTS(String statyear, String endyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KProresults record = new KProresults();
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setStatyear(statyear);
        record.setEndyear(endyear);
        return kProresultsMapper.countKPRORESULTS(record);
    }

    @Override
    public Integer countKPRORESULTSdept(String statyear, String endyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KProresults record = new KProresults();
        record.setDept(kKyuserMapper.selectByDept(kyname));
        record.setStatyear(statyear);
        record.setEndyear(endyear);
        return kProresultsMapper.countKPRORESULTSdept(record);
    }

    @Override
    public Integer countKPRORESULTSsch(String statyear, String endyear) {
        KProresults record = new KProresults();
        record.setStatyear(statyear);
        record.setEndyear(endyear);
        return kProresultsMapper.countKPRORESULTSsch(record);
    }

    @Override
    public Integer therecountKprojectresult(String statyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KProresults record = new KProresults();
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setStatyear(statyear);
        return kProresultsMapper.therecountKprojectresult(record);
    }

    @Override
    public Integer therecountKprojectresult2(String statyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KProresults record = new KProresults();
        record.setDept(kKyuserMapper.selectByDept(kyname));
        record.setStatyear(statyear);
        return kProresultsMapper.therecountKprojectresult2(record);
    }

    @Override
    public Integer therecountKprojectresult1(String statyear) {
        KProresults record = new KProresults();
        record.setStatyear(statyear);
        return kProresultsMapper.therecountKprojectresult1(record);
    }

    @Override
    public Integer deptcountKprojectresult(String statyear,String dept) {
        KProresults record = new KProresults();
        record.setDept(dept);
        record.setStatyear(statyear);
        return kProresultsMapper.deptcountKprojectresult(record);
    }
}
