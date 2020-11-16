package com.chengyong.mapper;

import com.chengyong.entity.KProject;
import com.chengyong.util.DataJson;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

public interface KProjectMapper {
    int deleteByPrimaryKey(Short pid);

    int insert(KProject record);

    int insertSelective(KProject record);

    KProject selectByPrimaryKey(Short pid);

    int updateByPrimaryKeySelective(KProject record);

    int updateByPrimaryKey(KProject record);

    int updateByPZJSOURCE(KProject kProject);

    KProject selectByPnameAndPPEOPLE(KProject kProject);

    String downcheck(Short pid);

    List<KProject> listProject(KProject kProject);

    List<KProject> sucProject1(KProject kProject);

    List<KProject> sucProject2(KProject kProject);

    List<KProject> sucProject3(KProject kProject);

    List<KProject> sucProject3Funding(KProject kProject);

    List<KProject> declareProject2(KProject kProject);

    List<KProject> listProjectSchool(KProject kProject);

    List<KProject> seachrProject(KProject kProject);

    List<KProject> seachrProjectSch(KProject kProject);

    int deleteByPPERNAME(Short pid);

    List<KProject> checklistProject(KProject kProject);

    List<KProject> checklistProject2(KProject kProject);

    List<KProject> checklistProject3(KProject kProject);

    List<KProject> delaylistProject3(KProject kProject);

    List<KProject> endlistProject1(KProject kProject);

    List<KProject> endlistProject3(KProject kProject);

    List<KProject> terminlistProject1(KProject kProject);

    List<KProject> terminlistProject2(KProject kProject);

    List<KProject> terminlistProject3(KProject kProject);

    int updateByPSB1(Short pid,Short psb1);

    int updateByPSB2(Short pid,Short psb2);

    int updateByPLX1(Short pid,Short plx1);

    int updateByPLX2(Short pid,Short plx2);

    int updateByPZJ1(Short pid,Short pzj1);

    int updateByPZJ2(Short pid,Short pzj2);

    int updateByPJX1(Short pid,Short pjx1);

    int updateByPJX2(Short pid,Short pjx2);

    int updateByPYQ1(Short pid,Short pyq1);

    int updateByPYQ2(Short pid,Short pyq2);

    String downProjectSch(Short pid);

    String selectPZJSOURCE(Short pid);
}