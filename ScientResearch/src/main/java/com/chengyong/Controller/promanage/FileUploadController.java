package com.chengyong.Controller.promanage;

import com.chengyong.util.PUBLIC_ATTRIBUTE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping("/proFile")
    public Map<String,Object> proFile(MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<>();
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1,file.getOriginalFilename().length());
        //获取项目本身的地址根目录
        String path = PUBLIC_ATTRIBUTE.UPLOAD_PATH_PRO;

        InputStream in = file.getInputStream();
        File file1 = new File(path);
       // 如果这个文件夹不存在就创建一个
		 		if(!file1.exists()){
                    file1.mkdir();
		 		}
        String filename = new Date().getTime()+"."+fileType;
        OutputStream out = new FileOutputStream(file1+"\\"+filename);
        byte[] b = new byte[1024];
        int len = 0;
        while((len=in.read(b))!=-1){
            out.write(b, 0, len);
        }
        in.close();
        out.close();
        request.getSession().setAttribute("pro_path",path+"/"+filename);
        map.put("info", PUBLIC_ATTRIBUTE.UPLOAD_SUCCESS);
        return map;
    }
}
