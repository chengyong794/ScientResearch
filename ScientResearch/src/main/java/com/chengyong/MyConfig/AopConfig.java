package com.chengyong.MyConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Configuration
public class AopConfig {

    private Logger logger = LoggerFactory.getLogger(AopConfig.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String time = format.format(new Date());

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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除菜单节点发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改菜单节点发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加菜单节点发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除角色发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改角色发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加角色发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------修改用户发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------删除用户发生异常---------########");
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
            return object;
        }catch (Exception e){
            logger.info(time+"########----------添加用户发生异常---------########");
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }

}
