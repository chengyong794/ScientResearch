package com.chengyong.Controller;

import com.chengyong.service.KProjectService;
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
}
