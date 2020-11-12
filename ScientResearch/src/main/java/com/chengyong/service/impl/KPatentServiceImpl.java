package com.chengyong.service.impl;

import com.chengyong.entity.KPatent;
import com.chengyong.entity.KWork;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KPatentMapper;
import com.chengyong.service.KPatentService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KPatentServiceImpl implements KPatentService {

    @Autowired
    private KPatentMapper kPatentMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Override
    public int deleteByPrimaryKey(Short zid) {
        return kPatentMapper.deleteByPrimaryKey(zid);
    }

    @Override
    public int deleteByPrimaryKeylow(Short[] zids) {
        try{
            for (Short zid:zids
            ) {
                kPatentMapper.deleteByPrimaryKey(zid);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insert(KPatent record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        record.setZresource((String) request.getSession().getAttribute("patent_path"));
        return kPatentMapper.insert(record);
    }

    @Override
    public int insertSelective(KPatent record) {
        return 0;
    }

    @Override
    public KPatent selectByPrimaryKey(Short zid) {
        return null;
    }

    @Override
    public String selectByPATH(Short zid) {
        return kPatentMapper.selectByPATH(zid);
    }

    @Override
    public int updateByPrimaryKeySelective(KPatent record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KPatent record) {
        String path = (String) request.getSession().getAttribute("patent_path");
        if(path==null){
            return kPatentMapper.updateByPrimaryKey1(record);
        }else{
            record.setZresource(path);
            return kPatentMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    public int updateByPrimaryKey1(KPatent record) {
        return kPatentMapper.updateByPrimaryKey1(record);
    }

    @Override
    public DataJson patentlist3(KPatent record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setKyid(kKyuserMapper.selectByuname(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KPatent> list  = kPatentMapper.patentlist3(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson patentlist2(KPatent record) {
        String kyname = (String) request.getSession().getAttribute("user");
        record.setZdept(kKyuserMapper.selectByDept(kyname));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KPatent> list  = kPatentMapper.patentlist2(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson patentlist1(KPatent record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KPatent> list  = kPatentMapper.patentlist1(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByZACHNUM2(Short zid, Short zachnum) {
        if(kPatentMapper.selectByzachnum(zid)==2){
            return 1;
        }
        return kPatentMapper.updateByZACHNUM2(zid, zachnum);
    }

    @Override
    public int updateByZACHNUM1(Short zid, Short zachnum) {
        return kPatentMapper.updateByZACHNUM1(zid, zachnum);
    }
}
