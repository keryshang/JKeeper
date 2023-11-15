package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: Kery
 * Date: 2023/11/15
 */
@RestController
@Api(tags = "ELKController")
@Tag(name = "ELKController", description = "ELK模块API")
@RequestMapping("/elk")
public class ELKController {
    @Value("${user.name}")
    private String username;

    @ApiOperation("获取用户名")
    @GetMapping("/getName")
    public CommonResult<String> getName(){
        String uaseName = username;
        return CommonResult.success(username);
    }
}
