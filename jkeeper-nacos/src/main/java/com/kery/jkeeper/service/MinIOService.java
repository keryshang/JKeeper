package com.kery.jkeeper.service;

import com.kery.jkeeper.common.api.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Description: MinIO对象存储服务
 * Author: Kery
 * Date: 2023/10/19
 */
public interface MinIOService {


    CommonResult upload(MultipartFile file);

    InputStream download(String objectName, HttpServletResponse response);

    CommonResult delete(String objectName);
}
