package com.chengyong.mapper;

import com.chengyong.entity.KKyuser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface KKyuserMapper {
    int deleteByPrimaryKey(Short kyid);

    int insert(KKyuser record);

    int insertSelective(KKyuser record);

    KKyuser selectByPrimaryKey(Short kyid);

    Short selectByuname(String kyname);

    String selectByDept(String kyname);

    int updateByPrimaryKeySelective(KKyuser record);

    int updateByPrimaryKey(KKyuser record);

    KKyuser loginUsername(String username);

    List<String> findUserRole(Short kyUserid);

    List<String> findRoleMenu(String username);

    List<String> findRoleKNODEURL(String username);

    List<KKyuser> listUser(KKyuser kKyuser);

    List<KKyuser> messagelistUser(KKyuser kKyuser);

    Short findUserRoleType(String username);

    String selectKYNAME(Short kyid);
}