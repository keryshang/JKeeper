package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:: Kery
 * @description:
 * @date: 2023/9/20 16:04
 **/
@Controller
@Api(tags = "RedisController")
@Tag(name = "RedisController", description = "Redis模块API")
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @ApiOperation("插入数据")
    @GetMapping("/insertData")
    @ResponseBody
    public CommonResult<Map> insertData(String key, String value){
        redisService.set(key, value);
        Map data = new HashMap<>();
        data.put(key, value);
        return CommonResult.success(data);
    }

    @ApiOperation("查询数据")
    @GetMapping("/queryData")
    @ResponseBody
    public CommonResult<String> queryData(String key){
        String value = (String) redisService.get(key);
        if (value != null && value != ""){
            return CommonResult.success(value);
        }
        return CommonResult.failed("无查询结果");
    }
}
