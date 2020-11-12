package com.chengyong.Controller;

import com.chengyong.service.*;
import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/down")
public class DownController {

    @Autowired
    private KProjectService kProjectService;

    @Autowired
    private KDelayprojectService kDelayprojectService;

    @Autowired
    private KThesisService kThesisService;

    @Autowired
    private KWorkService kWorkService;

    @Autowired
    private KProresultsService kProresultsService;

    @Autowired
    private KPatentService kPatentService;

    @RequestMapping("/downProjectSch")
    public void down(@Param("pid") Short pid, HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String path = kProjectService.downProjectSch(pid);
            //获取文件的名称
            File f = new File(path);
            FileInputStream inputStream = new FileInputStream(f);
            //设置下载时响应头
            response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
            //拿到响应输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //流的复制
            IOUtils.copy(inputStream,outputStream);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
    }



    @RequestMapping("/isTorF")
    @ResponseBody
    public Map<String,Object> isTorF(@Param("pid") Short pid) {
        Map<String,Object> map = new HashMap<>();
        String path = kProjectService.downProjectSch(pid);
        if(path==null||path.equals("")){
            map.put("info", 0);
        }else{
            map.put("info", 1);
        }

        return  map;
    }


    @RequestMapping("/downusersc")
    public void downusersc( HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String path = "D:\\Scient\\usersc\\user_sc.docx";
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }


    @RequestMapping("/downcheck")
    public void downcheck( HttpServletRequest request, HttpServletResponse response,@Param("pid") Short pid) throws IOException, IOException {

        String path = kProjectService.downcheck(pid);
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }


    @RequestMapping("/downdelay")
    public void downdelay( HttpServletRequest request, HttpServletResponse response,@Param("pdelayid") Short pdelayid) throws IOException, IOException {

        String path = kDelayprojectService.selectDelaypath(pdelayid);
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }


    @RequestMapping("/downpaper")
    public void downpaper( HttpServletRequest request, HttpServletResponse response,@Param("tid") Short tid) throws IOException, IOException {

        String path = kThesisService.selectBypath(tid);
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }


    @RequestMapping("/downbook")
    public void downbook( HttpServletRequest request, HttpServletResponse response,@Param("wid") Short wid) throws IOException, IOException {

        String path = kWorkService.selectByPath(wid);
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }

    @RequestMapping("/downprojectRes")
    public void downprojectRes( HttpServletRequest request, HttpServletResponse response,@Param("prid") Short prid) throws IOException, IOException {

        String path = kProresultsService.selectByPATH(prid);
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }

    @RequestMapping("/downpatent")
    public void downpatent( HttpServletRequest request, HttpServletResponse response,@Param("zid") Short zid) throws IOException, IOException {

        String path = kPatentService.selectByPATH(zid);
        //获取文件的名称
        File f = new File(path);
        FileInputStream inputStream = new FileInputStream(f);
        //设置下载时响应头
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(f.getName(),"UTF-8"));
        //拿到响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }
}
