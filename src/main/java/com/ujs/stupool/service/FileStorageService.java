package com.ujs.stupool.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    @Value("${file.location}")
    String filelocation;


    public String save(MultipartFile file) {
        String filename = String.valueOf(System.currentTimeMillis());
        String oname = file.getOriginalFilename();
        String[] s = oname.split("\\.");
        String Suffix = s[s.length - 1];
        filename += ("." + Suffix);
        File savePos = new File(filelocation+"images/");
        if (!savePos.exists()) {  // 不存在，则创建该文件夹
            savePos.mkdir();
        }
        try {


            savePos.setWritable(true);
            // 获取存放位置的规范路径
            String realPath = savePos.getCanonicalPath();
            // 上传该文件/图像至该文件夹下
            file.transferTo(new File(realPath + "/" + filename));

        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");

        }
        return filename;


    }
}
