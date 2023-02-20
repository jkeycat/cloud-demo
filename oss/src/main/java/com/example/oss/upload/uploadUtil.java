package com.example.oss.upload;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class uploadUtil {

    /*域名
    * */
    public  static  final  String ALI_DOMAIN="https://xieqiao-test.oss-cn-hangzhou.aliyuncs.com/";

    public static   String uploadImage(MultipartFile file) throws IOException {
        //生成文件名
        //file 图片重命名
        String originalFilename = file.getOriginalFilename(); //原来的图片名
        String ext="."+ FilenameUtils.getExtension(originalFilename);//获取文件后缀
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filename=uuid+ext; //新名字
        //地域节点
        String endPoint="http://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId="LTAI5tGFdaGFA6cEaEzwxfdp";
        String accessKeySecret="O0uiwPmhqrZicyEx905RKyiC0FT8LF";
        //oss客户端对象
        OSS oss = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
        /*
        * 仓库名、文件名、文件流
        * */
        oss.putObject("xieqiao-test",filename,file.getInputStream());
        oss.shutdown();
        return ALI_DOMAIN+filename;

    }
}
