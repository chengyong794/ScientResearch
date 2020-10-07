package com.chengyong.service.impl;

import com.chengyong.entity.Ktreenode;
import com.chengyong.mapper.KtreenodeMapper;
import com.chengyong.service.KtreenodeService;
import com.chengyong.util.DataTree;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import com.chengyong.util.RedisUtil;
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

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 删除节点
     * allEntries 清除所有缓存
     * beforeInvocation 在调用该方法前执行清除缓存操作
     * @param treenodeid
     * @return
     */
    @Override
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
                //删除数据记住要删除 该redis中的缓存
                //selectKview 代表左侧菜单的缓存
                redisUtil.del("listTreeNode","selectKview");

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
        record.setType((short)0);
        redisUtil.del("listTreeNode","selectKview");
        return ktreenodeMapper.insert(record);
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
        //删除数据记住要删除 该redis中的缓存
        // listTreeNode代表修改的该菜单的缓存
        //selectKview 代表左侧菜单的缓存
        redisUtil.del("listTreeNode","selectKview");
        return ktreenodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Ktreenode record) {
        return 0;
    }

    @Override
    public DataTree listTreeNode() {

        //进行redis key查询
        List<Ktreenode> list = (List<Ktreenode>)redisUtil.get("listTreeNode");
        //如果不为空就将redis中的值返回
        if(null != list){
            PageInfo<Ktreenode> listInfo = new PageInfo<>();
            return new DataTree(listInfo.getTotal(),list);
        }

        list = ktreenodeMapper.listTreeNode();
        PageInfo<Ktreenode> listInfo = new PageInfo<>();
        //为空就插入到redis
        redisUtil.set("listTreeNode",list);
        return new DataTree(listInfo.getTotal(),list);
    }
}
