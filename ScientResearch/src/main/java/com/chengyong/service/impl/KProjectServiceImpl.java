package com.chengyong.service.impl;

import com.chengyong.entity.KProject;
import com.chengyong.entity.KProjectper;
import com.chengyong.mapper.KProjectMapper;
import com.chengyong.mapper.KProjectperMapper;
import com.chengyong.service.KProjectService;
import com.chengyong.util.DataJson;
import com.chengyong.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Service
public class KProjectServiceImpl implements KProjectService {

    @Autowired
    private KProjectMapper kProjectMapper;

    @Autowired
    private KProjectperMapper kProjectperMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int deleteByPrimaryKey(Short pid) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        kProjectMapper.deleteByPPERNAME(pid);
        return kProjectMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public int insert(KProject record) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        String path = (String)request.getSession().getAttribute("pro_path");
        record.setPsource(path);
        return kProjectMapper.insert(record);
    }

    @Override
    public int insertSelective(KProject record) {
        return 0;
    }

    @Override
    public KProject selectByPrimaryKey(Short pid) {
        return kProjectMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int updateByPrimaryKeySelective(KProject record) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(KProject record) {

        return 0;
    }

    @Override
    public int updateByPZJSOURCE(KProject kProject) {
        return kProjectMapper.updateByPZJSOURCE(kProject);
    }

    @Override
    public String downcheck(Short pid) {
        return kProjectMapper.downcheck(pid);
    }

    @Override
    public KProject selectByPnameAndPPEOPLE(KProject kProject) {
        return kProjectMapper.selectByPnameAndPPEOPLE(kProject);
    }

    @Override
    public DataJson listProject(KProject kProject) {
        String name="";
        List<KProject> list  = (List<KProject>)redisUtil.get("listProject:listProject"+kProject.getPage()+kProject.getLimit());
        Integer total = (Integer)redisUtil.get("listProject:listProjecttotal"+kProject.getPage()+kProject.getLimit());
        if(list == null){
            PageHelper.startPage(kProject.getPage(),kProject.getLimit());
            list = kProjectMapper.listProject(kProject);
            for (KProject kp:list
            ) {
                List<String> kpper = kProjectperMapper.selectName(kp.getPid());
                if(kpper.size()==0||kpper==null){
                    kp.setMembers("");
                }else{
                    name = "";
                    for (String kper:kpper
                    ) {
                        name += kper+",";
                    }
                    kp.setMembers(name.substring(0,name.length()-1));
                }
            }

            PageInfo info = new PageInfo(list);
            total = (int)info.getTotal();

            redisUtil.set("listProject:listProject"+kProject.getPage()+kProject.getLimit(),list);
            redisUtil.set("listProject:listProjecttotal"+kProject.getPage()+kProject.getLimit(),total);
        }

        return new DataJson(total,list);
    }

    @Override
    public DataJson listProjectSchool(KProject kProject) {
        String name="";
        List<KProject> list  = (List<KProject>)redisUtil.get("listProjectSch:listProject"+kProject.getPage()+kProject.getLimit());
        Integer total = (Integer)redisUtil.get("listProjectSch:listProjecttotal"+kProject.getPage()+kProject.getLimit());
        if(list == null){
            PageHelper.startPage(kProject.getPage(),kProject.getLimit());
            list = kProjectMapper.listProjectSchool(kProject);
            for (KProject kp:list
            ) {
                List<String> kpper = kProjectperMapper.selectName(kp.getPid());
                if(kpper.size()==0||kpper==null){
                    kp.setMembers("");
                }else{
                    name = "";
                    for (String kper:kpper
                    ) {
                        name += kper+",";
                    }
                    kp.setMembers(name.substring(0,name.length()-1));
                }

            }

            PageInfo info = new PageInfo(list);
            total = (int)info.getTotal();

            redisUtil.set("listProjectSch:listProject"+kProject.getPage()+kProject.getLimit(),list);
            redisUtil.set("listProjectSch:listProjecttotal"+kProject.getPage()+kProject.getLimit(),total);
        }

        return new DataJson(total,list);
    }

    @Override
    public DataJson seachrProject(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.seachrProject(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson seachrProjectSch(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.seachrProjectSch(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson checklistProject(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.checklistProject(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson checklistProject2(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.checklistProject2(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson checklistProject3(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.checklistProject3(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson endlistProject1(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.endlistProject1(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public DataJson endlistProject3(KProject kProject) {
        PageHelper.startPage(kProject.getPage(),kProject.getLimit());
        List<KProject> list = kProjectMapper.endlistProject3(kProject);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public int updateByPSB1(Short pid, Short psb1) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPSB1( pid,  psb1);
    }

    @Override
    public int updateByPSB2(Short pid, Short psb2) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPSB2(pid,  psb2);
    }

    @Override
    public int updateByPLX1(Short pid, Short plx1) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPLX1(pid,plx1);
    }

    @Override
    public int updateByPLX2(Short pid, Short plx2) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPLX2(pid,plx2);
    }

    @Override
    public int updateByPZJ1(Short pid, Short pzj1) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPZJ1(pid,pzj1);
    }

    @Override
    public int updateByPZJ2(Short pid, Short pzj2) {
        Set<String> keys = redisUtil.keys("listProject*");
        redisUtil.delkeys(keys);
        Set<String> keys1 = redisUtil.keys("listProjectSch*");
        redisUtil.delkeys(keys1);
        return kProjectMapper.updateByPZJ2(pid, pzj2);
    }

    @Override
    public int updateByPJX1(Short pid, Short pjx1) {
        return kProjectMapper.updateByPJX1(pid, pjx1);
    }

    @Override
    public int updateByPJX2(Short pid, Short pjx2) {
        return kProjectMapper.updateByPJX2(pid, pjx2);
    }

    @Override
    public String downProjectSch(Short pid) {
        return kProjectMapper.downProjectSch(pid);
    }

}
