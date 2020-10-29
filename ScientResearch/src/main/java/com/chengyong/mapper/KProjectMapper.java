package com.chengyong.mapper;

import com.chengyong.entity.KProject;
import com.chengyong.util.DataJson;

import java.util.List;

public interface KProjectMapper {
    int deleteByPrimaryKey(Short pid);

    int insert(KProject record);

    int insertSelective(KProject record);

    KProject selectByPrimaryKey(Short pid);

    int updateByPrimaryKeySelective(KProject record);

    int updateByPrimaryKey(KProject record);

    KProject selectByPnameAndPPEOPLE(KProject kProject);

    List<KProject> listProject(KProject kProject);

    List<KProject> listProjectSchool(KProject kProject);

    List<KProject> seachrProject(KProject kProject);

    List<KProject> seachrProjectSch(KProject kProject);

    int deleteByPPERNAME(Short pid);

    int updateByPSB1(Short pid,Short psb1);

    int updateByPSB2(Short pid,Short psb2);

    int updateByPLX1(Short pid,Short plx1);

    int updateByPLX2(Short pid,Short plx2);

    String downProjectSch(Short pid);
}