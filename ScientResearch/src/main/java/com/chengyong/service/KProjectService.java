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

    KProject selectByPnameAndPPEOPLE(KProject kProject);

    DataJson listProject(KProject kProject);

    DataJson listProjectSchool(KProject kProject);

    DataJson seachrProject(KProject kProject);

    DataJson seachrProjectSch(KProject kProject);

    int updateByPSB1(Short pid,Short psb1);

    int updateByPSB2(Short pid,Short psb2);

    int updateByPLX1(Short pid,Short plx1);

    int updateByPLX2(Short pid,Short plx2);

    String downProjectSch(Short pid);

}
