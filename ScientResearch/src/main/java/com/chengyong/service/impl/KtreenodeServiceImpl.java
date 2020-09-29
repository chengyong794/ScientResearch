package com.chengyong.service.impl;

import com.chengyong.entity.Ktreenode;
import com.chengyong.mapper.KtreenodeMapper;
import com.chengyong.service.KtreenodeService;
import com.chengyong.util.DataTree;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KtreenodeServiceImpl implements KtreenodeService {
    @Autowired
    private KtreenodeMapper ktreenodeMapper;

    /**
     * 删除节点
     * allEntries 清除所有缓存
     * beforeInvocation 在调用该方法前执行清除缓存操作
     * @param treenodeid
     * @return
     */
    @Override
    @CacheEvict(value = "listTreeNode",allEntries = true,beforeInvocation=true)
    public String deleteByPrimaryKey(Short treenodeid) {
        boolean flag = true;
        List<Ktreenode> list = ktreenodeMapper.listTreeNode();
        for (Ktreenode treenode:
             list) {
            if(flag){
                if(treenode.getParentid()==treenodeid){
                    flag = false;
                }
            }else{
                break;
            }
        }
        if(flag){
            try {
                ktreenodeMapper.deleteByPrimaryKey(treenodeid);
                return PUBLIC_ATTRIBUTE.DELETE;
            }catch (Exception e){
                return PUBLIC_ATTRIBUTE.DELETE_ERROR;
            }
        }else{
            return PUBLIC_ATTRIBUTE.DELETE_PARENTID;
        }
    }

    @Override
    public int insert(Ktreenode record) {
        return 0;
    }

    @Override
    public int insertSelective(Ktreenode record) {
        return 0;
    }

    @Override
    public Ktreenode selectByPrimaryKey(Short treenodeid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Ktreenode record) {
        return ktreenodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @CacheEvict(value = "listTreeNode",allEntries = true)
    public int updateByPrimaryKey(Ktreenode record) {
        return ktreenodeMapper.updateByPrimaryKey(record);
    }

    @Override
    @Cacheable(value = "listTreeNode")
    public DataTree listTreeNode() {
        List<Ktreenode> list = ktreenodeMapper.listTreeNode();
        PageInfo<Ktreenode> listInfo = new PageInfo<>();
        return new DataTree(listInfo.getTotal(),list);
    }
}
