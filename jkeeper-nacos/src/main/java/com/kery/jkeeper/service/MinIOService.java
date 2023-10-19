package com.kery.jkeeper.service;

import com.kery.jkeeper.common.api.CommonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description: MinIO对象存储服务
 * Author: Kery
 * Date: 2023/10/19
 */
public interface MinIOService {


    CommonResult upload(MultipartFile file);

    CommonResult delete(String objectName);
}
