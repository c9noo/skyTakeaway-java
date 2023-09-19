package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @program: sky-take-out
 * @ClassName commonController
 * @author: c9noo
 * @create: 2023-09-19 09:28
 * @Version 1.0
 * 通用接口
 **/
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "通用接口")
public class commonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public Result<String> upload(MultipartFile file){
        log.info("文件开始上传");
        try {
            //1. 获取原始文件名
            String originalFilename = file.getOriginalFilename();
            //2. 截取后缀
            String substring = originalFilename.substring(originalFilename.lastIndexOf('.'));
            String upload = aliOssUtil.upload(file.getBytes(), UUID.randomUUID().toString() + substring);
            return Result.success(upload);
        } catch (IOException e) {
            log.info("文件上传失败");
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
