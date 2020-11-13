package com.chengyong.service.impl;

import com.chengyong.entity.KThesis;
import com.chengyong.entity.KWork;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KWorkMapper;
import com.chengyong.service.KWorkService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KWorkServiceImpl implements KWorkService {

    @Autowired
    private KWorkMapper kWorkMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Override
    public int deleteByPrimaryKey(Short wid) {

        return kWorkMapper.deleteByPrimaryKey(wid);
    }

    @Override
    public int deleteByPrimaryKeylow(Short[] wids) {
        try{
            for (Short wid:wids
            ) {
                kWorkMapper.deleteByPrimaryKey(wid);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insert(KWork record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setWresource((String) request.getSession().getAttribute("book_path"));
        return kWorkMapper.insert(record);
    }

    @Override
    public int insertSelective(KWork record) {
        return 0;
    }

    @Override
    public KWork selectByPrimaryKey(Short wid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KWork record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KWork record) {
        String path = (String) request.getSession().getAttribute("book_path");
        if(path==null){
            return kWorkMapper.updateByPrimaryKey1(record);
        }else{
            record.setWresource(path);
            return kWorkMapper.updateByPrimaryKey(record);
        }

    }

    @Override
    public DataJson booklistResult3(KWork record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KWork> list  = kWorkMapper.booklistResult3(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson booklistResult2(KWork record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setWdept(kKyuserMapper.selectByDept(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KWork> list  = kWorkMapper.booklistResult2(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson booklistResult1(KWork record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KWork> list  = kWorkMapper.booklistResult1(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByWACHNUM1(Short wid, Short wachnum) {
        return kWorkMapper.updateByWACHNUM1(wid, wachnum);
    }

    @Override
    public int updateByWACHNUM2(Short wid, Short wachnum) {
        if(kWorkMapper.selectBywachnum(wid)==2){
            return 1;
        }
        return kWorkMapper.updateByWACHNUM2(wid, wachnum);
    }

    @Override
    public String selectByPath(Short wid) {
        return kWorkMapper.selectByPath(wid);
    }

    @Override
    public Integer countKWork(String statyear, String endyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KWork record = new KWork();
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setStatyear(statyear);
        record.setEndyear(endyear);
        return kWorkMapper.countKWork(record);
    }

    @Override
    public Integer countKWorkdept(String statyear, String endyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KWork record = new KWork();
        record.setWdept(kKyuserMapper.selectByDept(kyname));
        record.setStatyear(statyear);
        record.setEndyear(endyear);
        return kWorkMapper.countKWorkdept(record);
    }

    @Override
    public Integer countKWorksch(String statyear, String endyear) {
        KWork record = new KWork();
        record.setStatyear(statyear);
        record.setEndyear(endyear);
        return kWorkMapper.countKWorksch(record);
    }

    @Override
    public Integer therecountKWork(String statyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KWork record = new KWork();
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setStatyear(statyear);
        return kWorkMapper.therecountKWork(record);
    }

    @Override
    public Integer therecountKWork2(String statyear) {
        String kyname = (String) request.getSession().getAttribute("user");
        KWork record = new KWork();
        record.setWdept(kKyuserMapper.selectByDept(kyname));
        record.setStatyear(statyear);
        return kWorkMapper.therecountKWork2(record);
    }

    @Override
    public Integer therecountKWork1(String statyear) {
        KWork record = new KWork();
        record.setStatyear(statyear);
        return kWorkMapper.therecountKWork1(record);
    }

    @Override
    public Integer deptcountKWork(String statyear,String dept) {
        KWork record = new KWork();
        record.setWdept(dept);
        record.setStatyear(statyear);
        return kWorkMapper.deptcountKWork(record);
    }
}
