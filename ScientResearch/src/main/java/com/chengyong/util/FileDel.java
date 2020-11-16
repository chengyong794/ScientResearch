package com.chengyong.util;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileDel {
    public void delF(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }
}
