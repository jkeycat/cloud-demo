package com.example.oss.controller;

import com.example.oss.upload.uploadUtil;
import javafx.application.Application;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class uploadController {
    @PostMapping("/upload")
    public String upload(MultipartFile file){
        //file校验
        if(file.isEmpty()){
            return "图片上传失败";
        }
        //file 图片重命名
        String originalFilename = file.getOriginalFilename(); //原来的图片名
        String ext="."+originalFilename.split("\\.")[1];//获取文件后缀
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filename=uuid+ext; //新名字
        //上传图片
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String pre=applicationHome.getDir().getParentFile().getParentFile().getAbsoluteFile()+
                "\\src\\main\\resources\\images\\";
        String  path=pre+filename;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  path;
    }


    @PostMapping("/upImg")
    public String unImg(MultipartFile file) throws IOException {
        return uploadUtil.uploadImage(file);
    }
}
