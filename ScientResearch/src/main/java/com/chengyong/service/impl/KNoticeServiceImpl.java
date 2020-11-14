package com.chengyong.service.impl;

import com.chengyong.entity.KNotice;
import com.chengyong.mapper.KNoticeMapper;
import com.chengyong.service.KNoticeService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KNoticeServiceImpl implements KNoticeService {

    @Autowired
    private KNoticeMapper kNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Short nid) {
        return kNoticeMapper.deleteByPrimaryKey(nid);
    }

    @Override
    public int deleteByPrimaryKeylow(Short[] nids) {
        try{
            for (Short nid:nids
            ) {
                kNoticeMapper.deleteByPrimaryKey(nid);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insert(KNotice record) {
        String context = "";
        for (int i = 0; i < record.getNcontext().length(); i+=15) {
            if(i+15<record.getNcontext().length()){
                context += record.getNcontext().substring(i,i+15)+"<br/>";
            }else{
                context += record.getNcontext().substring(i,record.getNcontext().length());
            }
        }
        record.setNcontext(context);
        return kNoticeMapper.insert(record);
    }

    @Override
    public int insertSelective(KNotice record) {
        return 0;
    }

    @Override
    public KNotice selectByPrimaryKey(Short nid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KNotice record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KNotice record) {
        return kNoticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataJson ListNotice(KNotice record) {
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KNotice> list  = kNoticeMapper.ListNotice(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }
}
