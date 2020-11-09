package com.chengyong.service.impl;

import com.chengyong.entity.KPostproject;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.mapper.KPostprojectMapper;
import com.chengyong.mapper.KProjectMapper;
import com.chengyong.service.KPostprojectService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KPostprojectServiceImpl implements KPostprojectService {

    @Autowired
    private KPostprojectMapper kPostprojectMapper;

    @Autowired
    private KProjectMapper kProjectMapper;

    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public DataJson K_POSTPROJECTlist1(KPostproject kPostproject) {
        PageHelper.startPage(kPostproject.getPage(),kPostproject.getLimit());
        List<KPostproject> list = kPostprojectMapper.K_POSTPROJECTlist1(kPostproject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson K_POSTPROJECTlist2(KPostproject kPostproject) {
        String kyname = (String) request.getSession().getAttribute("user");
        kPostproject.setPpdept(kKyuserMapper.selectByDept(kyname));
        PageHelper.startPage(kPostproject.getPage(),kPostproject.getLimit());
        List<KPostproject> list = kPostprojectMapper.K_POSTPROJECTlist2(kPostproject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByPPSTATE1(Short ppid, Short ppstate1,Short pid) {
        kProjectMapper.updateByPJX1(pid,ppstate1);
        return kPostprojectMapper.updateByPPSTATE1(ppid,ppstate1);
    }

    @Override
    public int updateByPPSTATE2(Short ppid, Short ppstate2,Short pid) {
        kProjectMapper.updateByPJX2(pid,ppstate2);
        return kPostprojectMapper.updateByPPSTATE2(ppid,ppstate2);
    }


    @Override
    public int deleteByPrimaryKey(Short ppid) {
        return 0;
    }

    @Override
    public int insert(KPostproject kPostproject) {
        KPostproject kpost = new KPostproject();
        kpost.setPpname(kPostproject.getPname());
        kpost.setPpnum(kPostproject.getPcname());
        kpost.setPppeople(kPostproject.getMembers());
        kpost.setPpcontrol(kPostproject.getPpeople());
        kpost.setPpstate3(kPostproject.getPpstate3());
        kpost.setPpcome(kPostproject.getPccome());
        kpost.setPptype(kPostproject.getPcclasify());
        kpost.setPpdept(kPostproject.getPdept());
        kpost.setPpstarttime(kPostproject.getPpstarttime());
        kpost.setPpendtime(kPostproject.getPpendtime());
        kpost.setPpadjuct(kPostproject.getPpadjuct());
        kpost.setPpform(kPostproject.getPpform());
        kpost.setPpstatus(kPostproject.getPpstatus());
        kpost.setPpremak(kPostproject.getPpremak());
        kpost.setSubtime(kPostproject.getSubtime());
        kpost.setPid(kPostproject.getPid());
        try{
            return kPostprojectMapper.insert(kpost);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }


    }

    @Override
    public int insertSelective(KPostproject record) {
        return 0;
    }

    @Override
    public KPostproject selectByPrimaryKey(Short ppid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KPostproject record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KPostproject record) {
        return 0;
    }
}
