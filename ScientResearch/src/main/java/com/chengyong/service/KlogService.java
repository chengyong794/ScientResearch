package com.chengyong.service;

import com.chengyong.entity.Klog;
import com.chengyong.util.DataJson;
import org.springframework.stereotype.Service;

@Service
public interface KlogService {
    DataJson listLog(Klog klog);

    DataJson listBy(Klog klog);

    int insert(Klog klog);
}
