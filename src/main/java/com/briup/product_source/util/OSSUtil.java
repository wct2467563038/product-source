package com.briup.product_source.util;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Data
@Component
@ConfigurationProperties(prefix = "oos")
public class OSSUtil {
    private  String accessKey;
    private   String secretKey;
    private   String bucket;


    public  String upload(String fileName, InputStream in){
        String newFileName = UUID.randomUUID().toString().concat("-").concat(fileName);
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
//默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            uploadManager.put(in, fileName, upToken,null,null);
                //解析上传成功的结果
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        return newFileName;
    }
}
