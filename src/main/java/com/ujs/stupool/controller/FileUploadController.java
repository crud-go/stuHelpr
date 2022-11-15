package com.ujs.stupool.controller;


import com.ujs.stupool.model.response.CommonRes;
import com.ujs.stupool.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.net.InetAddress;


@RestController
public class FileUploadController {

    @Autowired
    FileStorageService storageService;


    @PostMapping("/upload")
    public ResponseEntity<CommonRes> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        try {
          String filename= storageService.save(file);



            String url="http://121.4.57.111:8086/static/images/"+filename;


            return ResponseEntity.status(HttpStatus.OK).body(new CommonRes(1,url));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CommonRes(0,message));
        }
    }



}
