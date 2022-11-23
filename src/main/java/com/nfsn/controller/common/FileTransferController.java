package com.nfsn.controller.common;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: FileTransferController
 * @Author: 团子tz
 * @CreateTime: 2022/11/20 17:22
 * @Description: 文件传输操作类【暂定】
 */
@RestController
@RequestMapping("/upload")
@Api("文件传输操作类")
public class FileTransferController {

    /**
     * 单文件上传
     * MultipartFile 自动封装上传过来的文件
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/monofile")
    public void upload(@RequestPart("headerImg") MultipartFile file) throws IOException {
        //保存到本地
        if(!file.isEmpty()){
            //拿到原始的文件名
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("C:\\cache\\"+originalFilename));
        }
    }

}