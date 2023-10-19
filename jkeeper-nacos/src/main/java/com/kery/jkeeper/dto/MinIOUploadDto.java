package com.kery.jkeeper.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description:
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
