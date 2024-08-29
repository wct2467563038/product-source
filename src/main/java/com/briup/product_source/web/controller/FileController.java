package com.briup.product_source.web.controller;

import com.briup.product_source.config.UploadProperties;
import com.briup.product_source.util.OSSUtil;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Slf4j
@Api(tags = "文件上传模块")
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${upload.filePath}")
    private String filePath;

    @Value("${upload.serverPath}")
    private String serverPath;
    @Autowired
    private OSSUtil ossUtil;



    @Autowired
    private UploadProperties prop;

    @ApiOperation("文件上传本地")
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        log.info("文件名："+filename+"  文件大小："+size);
        byte[] bytes = file.getBytes();
        String id = UUID.randomUUID().toString();
        String s = id + "-"+filename;
        file.transferTo(new File(filePath,s));
        return prop.getBaseUrl()+s;

    }
    @ApiOperation("文件上传云端")
    @PostMapping("/upload/qiniuyun")
    public Result<String> uploadByIdOSS(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();

        long size = file.getSize();
        log.info("文件名："+filename+"  文件大小："+size);

        String id = UUID.randomUUID().toString();
        String s = id + "-"+filename;

        InputStream in = file.getInputStream();
        String newFilename =ossUtil.upload(s,in);
        return ResultUtil.success(s);
    }
}
