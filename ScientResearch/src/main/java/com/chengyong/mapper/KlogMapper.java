package com.chengyong.mapper;

import com.chengyong.entity.Klog;

import java.util.List;

public interface KlogMapper {
    List<Klog> listLog(Klog klog);

    int insert(Klog klog);
}
