package com.chengyong.service.impl;

import com.chengyong.Controller.echart.EchartController;
import com.chengyong.entity.KInfo;
import com.chengyong.entity.KProresults;
import com.chengyong.mapper.KInfoMapper;
import com.chengyong.mapper.KKyuserMapper;
import com.chengyong.service.KInfoService;
import com.chengyong.util.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class KInfoServiceImpl implements KInfoService {

    @Autowired
    private KInfoMapper kInfoMapper;
    @Autowired
    private KKyuserMapper kKyuserMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public int deleteByPrimaryKey(Short iid) {
        return kInfoMapper.deleteByPrimaryKey(iid);
    }

    @Override
    public int insert(KInfo record,Short kyid) {
        String kyname = kKyuserMapper.selectKYNAME(kyid);
        record.setIatta((String)request.getSession().getAttribute("message_path"));
        record.setInfoperson(kyname);
        return kInfoMapper.insert(record);
    }

    @Override
    public int insertlow(KInfo record, Short[] kyids) {
        try{
            for (Short kyid:kyids
            ) {
                String kyname = kKyuserMapper.selectKYNAME(kyid);
                record.setIatta((String)request.getSession().getAttribute("message_path"));
                record.setInfoperson(kyname);
                kInfoMapper.insert(record);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }


    }

    @Override
    public int insertSelective(KInfo record) {
        return 0;
    }

    @Override
    public KInfo selectByPrimaryKey(Short iid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(KInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KInfo record) {
        return 0;
    }

    @Override
    public DataJson MessageList(KInfo record) {
        String kyname = (String) request.getSession().getAttribute("user");
        Short kyid = kKyuserMapper.selectByuname(kyname);
        record.setInfoperson(kKyuserMapper.selectKYNAME(kyid));
        PageHelper.startPage(record.getPage(),record.getLimit());
        List<KInfo> list  = kInfoMapper.MessageList(record);
        PageInfo info = new PageInfo(list);
        return new DataJson(info.getTotal(),list);
    }

    @Override
    public String selectByPath(Short iid) {
        return kInfoMapper.selectByPath(iid);
    }
}
