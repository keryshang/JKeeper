package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.service.MinIOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Description: MinIO对象存储管理
 * Author: Kery
 * Date: 2023/10/19
 */
@Slf4j
@Api(tags = "MinIOController")
@Tag(name = "MinIOController", description = "MinIO对象存储管理")
@RestController("/minio")
public class MinIOController {
    @Autowired
    private MinIOService minIOService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public CommonResult upload(@RequestPart("file") MultipartFile file){
        return minIOService.upload(file);
    }

    @ApiOperation("文件删除")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("objectName") String objectName){
        return minIOService.delete(objectName);
    }


}
