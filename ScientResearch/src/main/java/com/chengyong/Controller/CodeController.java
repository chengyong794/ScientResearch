package com.chengyong.Controller;

import com.chengyong.util.CpachaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/code")
public class CodeController {
    @RequestMapping("/kycode")
    public void vcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CpachaUtil  cpachaUtil = new CpachaUtil(4,116,36); //使用验证码工具类设置大小
        String vcode = cpachaUtil.generatorVCode();  // 生成字母

        request.getSession().setAttribute("code", vcode);

        BufferedImage generatorVCodeImage = cpachaUtil.generatorVCodeImage(vcode, true);  //生成图片将字母 写入图片，并且加斜线
        //将图片发送给前端页面,1.要发送的图片，2.发送的图片格式，3.发送
        ImageIO.write(generatorVCodeImage, "png", response.getOutputStream());
    }
}
