package com.chengyong.service;

import com.chengyong.entity.KProject;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface KProjectService {
    int deleteByPrimaryKey(Short pid);

    int insert(KProject record);

    int insertSelective(KProject record);

    KProject selectByPrimaryKey(Short pid);

    int updateByPrimaryKeySelective(KProject record);

    int updateByPrimaryKey(KProject record);

    int updateByPZJSOURCE(KProject kProject);

    String downcheck(Short pid);

    KProject selectByPnameAndPPEOPLE(KProject kProject);

    DataJson sucProject1(KProject kProject);

    DataJson sucProject2(KProject kProject);

    DataJson sucProject3(KProject kProject);

    DataJson sucProject3Funding(KProject kProject);

    DataJson declareProject2(KProject kProject);

    DataJson listProjectSchool(KProject kProject);

    DataJson seachrProjectSch(KProject kProject);

    DataJson checklistProject(KProject kProject);

    DataJson checklistProject2(KProject kProject);

    DataJson checklistProject3(KProject kProject);

    DataJson delaylistProject3(KProject kProject);

    DataJson endlistProject1(KProject kProject);

    DataJson endlistProject3(KProject kProject);

    DataJson terminlistProject1(KProject kProject);

    DataJson terminlistProject2(KProject kProject);

    DataJson terminlistProject3(KProject kProject);

    int updateByPSB1(Short pid,Short psb1);

    int updateByPSB2(Short pid,Short psb2);

    int updateByPLX1(Short pid,Short plx1);

    int updateByPLX2(Short pid,Short plx2);

    int updateByPZJ1(Short pid,Short pzj1);

    int updateByPZJ2(Short pid,Short pzj2);

    int updateByPJX1(Short pid,Short pzj1);

    int updateByPJX2(Short pid,Short pzj2);

    String downProjectSch(Short pid);

}
