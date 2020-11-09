package com.chengyong.service;

import com.chengyong.entity.KThesis;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KThesisService {

    int deleteByPrimaryKey(Short tid);

    int insert(KThesis record);

    int insertSelective(KThesis record);

    KThesis selectByPrimaryKey(Short tid);

    DataJson thesislistResult3(KThesis record);

    int updateByPrimaryKeySelective(KThesis record);

    int updateByPrimaryKey(KThesis record);

}
