package com.chengyong.service;

import com.chengyong.entity.KProject;
import org.springframework.stereotype.Service;

@Service
public interface KProjectService {
    int deleteByPrimaryKey(Short pid);

    int insert(KProject record);

    int insertSelective(KProject record);

    KProject selectByPrimaryKey(Short pid);

    int updateByPrimaryKeySelective(KProject record);

    int updateByPrimaryKey(KProject record);

    KProject selectByPnameAndPPEOPLE(KProject kProject);
}
