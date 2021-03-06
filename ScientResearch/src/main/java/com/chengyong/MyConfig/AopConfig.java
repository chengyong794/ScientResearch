package com.chengyong.MyConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Configuration
public class AopConfig {

    private Logger logger = LoggerFactory.getLogger(AopConfig.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String time = format.format(new Date());

    @Autowired
    private HttpServletRequest request;


    /**
     * 科研人员修改了著作
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KWorkServiceImpl.updateByPrimaryKey(..))")
    public Object KWorkServiceImplupdateByPrimaryKey(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员修改了著作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员修改著作成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员修改著作发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员添加了著作
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KWorkServiceImpl.insert(..))")
    public Object KWorkServiceImplinsert(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员添加了著作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员添加著作成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员添加著作发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员删除了著作
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KWorkServiceImpl.deleteByPrimaryKey(..))")
    public Object KWorkServiceImpldeleteByPrimaryKey(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员删除了著作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员删除著作成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员删除著作发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员批量删除了著作
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KWorkServiceImpl.deleteByPrimaryKeylow(..))")
    public Object KWorkServiceImpldeleteByPrimaryKeylow(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员批量删除了著作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员批量删除著作成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员批量删除著作发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }


    /**
     * 科研人员批量删除了论文
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KThesisServiceImpl.deleteByPrimaryKeylow(..))")
    public Object KThesisServiceImpldeleteByPrimaryKeylow(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员批量删除了论文---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员批量删除论文成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员批量删除论文发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员删除了论文
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KThesisServiceImpl.deleteByPrimaryKey(..))")
    public Object KThesisServiceImpldeleteByPrimaryKey(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员删除了论文---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员删除论文成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员删除论文发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员修改了论文
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KThesisServiceImpl.updateByPrimaryKey(..))")
    public Object KThesisServiceImplupdateByPrimaryKey(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员修改了论文---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员修改论文成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员修改论文发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员添加了论文
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KThesisServiceImpl.insert(..))")
    public Object KThesisServiceImplinsert(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员添加了论文---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员添加论文成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员添加论文发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 校系科研人员修改项目
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KProjectServiceImpl.updateByPrimaryKeySelective(..))")
    public Object KProjectupdateByPrimaryKeySelective(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------校系科研人员修改项目---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------校系科研人员修改项目成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------校系科研人员修改项目发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 科研人员添加了项目
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KProjectServiceImpl.insert(..))")
    public Object KProjectinsert(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------科研人员添加了项目---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------科研人员添加了项目成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------科研人员添加了项目发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 校系科研秘书删除项目
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KProjectServiceImpl.deleteByPrimaryKey(..))")
    public Object KProjectdeleteByPrimaryKey(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了校系科研秘书删除项目操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------校系科研秘书删除项目成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------校系科研秘书删除项目发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 添加项目批次申报
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KPiciServiceImpl.updateByPrimaryKey(..))")
    public Object KPiciupdate(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了修改项目批次申报的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------修改项目批次申报成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改项目批次申报发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 添加项目批次申报
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KPiciServiceImpl.insert(..))")
    public Object KPiciinsert(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了添加项目批次申报的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------添加项目批次申报成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加项目批次申报发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 删除删除项目批次申报
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KPiciServiceImpl.deleteByPrimaryKey(..))")
    public Object KPicidelete(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了删除项目批次申报的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------删除项目批次申报成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除项目批次申报发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 删除菜单节点
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KtreenodeServiceImpl.deleteByPrimaryKey(..))")
    public Object aroundKtreenodedelete(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了删除菜单节点的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------删除菜单节点成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除菜单节点发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 修改菜单节点
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KtreenodeServiceImpl.updateByPrimaryKeySelective(..))")
    public Object aroundKtreenodeupdate(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了修改菜单节点的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------修改菜单节点成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改菜单节点发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 添加菜单节点
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KtreenodeServiceImpl.insert(..))")
    public Object aroundKtreenodeinsert(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了添加菜单节点的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------添加菜单节点成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加菜单节点发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 删除角色
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KKyroleServiceImpl.deleteByPrimaryKey(..))")
    public Object aroundroledelete(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了删除角色的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------删除角色成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除角色发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 修改角色
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KKyroleServiceImpl.updateByPrimaryKey(..))")
    public Object aroundroleupdate(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了修改角色的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------修改角色成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改角色发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 添加角色
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.impl.KKyroleServiceImpl.insert(..))")
    public Object aroundinsert(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了添加角色的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------添加角色成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加角色发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 修改用户
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.KKyuserService.editUser(..))")
    public Object aroundeditUser(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了修改用户的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------修改用户成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改用户发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 删除用户
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.KKyuserService.delUser(..))")
    public Object arounddelUser(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了删除用户的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------删除用户成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除用户发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

    /**
     * 添加用户
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.chengyong.service.KKyuserService.addUser(..))")
    public Object aroundaddUser(ProceedingJoinPoint proceedingJoinPoint){
        try{
            logger.info(time+"########----------进行了添加用户的操作---------########");
            Object object = proceedingJoinPoint.proceed();
            logger.info(time+"########----------添加用户成功返回---------########"+object);
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加用户发生异常---------########");
            logger.info(time+"########----------IP=="+request.getRemoteAddr()+"---------########");
            logger.info(time+"########----------URL=="+request.getRequestURL()+"---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

}
