package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "NacosController")
@Tag(name = "NacosController", description = "Nacos模块API")
@RequestMapping("/nacos")
public class NacosController {

    @Value("${user.name}")
    private String username;

    @Value("${user.age}")
    private String age;

    @ApiOperation("获取用户名")
    @GetMapping("/quryName")
    @ResponseBody
    public CommonResult<String> queryName(){
        String uaseName = username;
        return CommonResult.success(username);
    }

    @ApiOperation("获取年龄")
    @GetMapping("/queryAge")
    @ResponseBody
    public CommonResult<String> queryAge(){
        return CommonResult.success(age);
    }

}
