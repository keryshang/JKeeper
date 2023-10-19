package com.kery.jkeeper.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.dto.BucketPolicyConfigDto;
import com.kery.jkeeper.dto.MinIOUploadDto;
import com.kery.jkeeper.service.MinIOService;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: MinIO对象存储服务实现
 * Author: Kery
 * Date: 2023/10/19
 */
@Slf4j
@Service
public class MinIOServiceImpl implements MinIOService {

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;
    @Override
    public CommonResult upload(MultipartFile file) {
        try {
            //创建一个MinIO的Java客户端
            MinioClient minioClient =MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (!isExist) {
                log.info("存储桶不存在，创建存储桶！");
                //创建存储桶并设置只读权限
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
                BucketPolicyConfigDto bucketPolicyConfigDto = createBucketPolicyConfigDto(BUCKET_NAME);
                SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
                        .bucket(BUCKET_NAME)
                        .config(JSONUtil.toJsonStr(bucketPolicyConfigDto))
                        .build();
                minioClient.setBucketPolicy(setBucketPolicyArgs);
            }
            String filename = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" + filename;
            // 使用putObject上传一个文件到存储桶中
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(BUCKET_NAME)
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE).build();
            minioClient.putObject(putObjectArgs);
            //文件URL地址
            String fileUrl = ENDPOINT + "/" + BUCKET_NAME + "/" + objectName;
            log.info("文件上传成功！文件名：{}，URL：{}", filename, fileUrl);
            MinIOUploadDto minIOUploadDto = new MinIOUploadDto();
            minIOUploadDto.setName(filename);
            minIOUploadDto.setUrl(fileUrl);
            return CommonResult.success(minIOUploadDto);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("上传发生错误: {}！", e.getMessage());
        }
        return CommonResult.failed();
    }

    private BucketPolicyConfigDto createBucketPolicyConfigDto(String bucketName) {
        BucketPolicyConfigDto.Statement statement = BucketPolicyConfigDto.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action("s3:GetObject")
                .Resource("arn:aws:s3:::"+bucketName+"/*.**").build();
        return BucketPolicyConfigDto.builder()
                .Version("2012-10-17")
                .Statement(CollUtil.toList(statement))
                .build();
    }

    @Override
    public InputStream download(String objectName, HttpServletResponse response) {
        //objectName需要包含存储桶下级文件目录名，例如:20231019/微信图片_20230919151908.jpg
        try {
            //创建一个MinIO的Java客户端
            MinioClient minioClient =MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            FilterInputStream file = minioClient.getObject(GetObjectArgs.builder().bucket(BUCKET_NAME).object(objectName).build());
            response.setHeader("Content-Disposition", "attachment;filename=" + objectName);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = file.read(buffer)) > 0) {
                servletOutputStream.write(buffer, 0, len);
            }
            servletOutputStream.flush();
            file.close();
            servletOutputStream.close();
            log.info("文件下载成功！文件名：{}", objectName);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件下载报错：{}", e.getMessage());
        }
        return null;
    }



    @Override
    public CommonResult delete(String objectName) {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(ENDPOINT)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(BUCKET_NAME).object(objectName).build());
            log.info("文件删除成功！文件名：{}", objectName);
            return CommonResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("文件删除发生错误：{}!",e.getMessage());
        }
        return CommonResult.failed();
    }
}
