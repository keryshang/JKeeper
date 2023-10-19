package com.kery.jkeeper.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: MinIO上传文件参数
 * Author: Kery
 * Date: 2023/10/19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinIOUploadDto {

    @ApiModelProperty("文件访问URL")
    private String url;
    @ApiModelProperty("文件名称")
    private String name;
}
