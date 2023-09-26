package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/26
 */
@Api(tags = "SentinelController")
@Tag(name = "SentinelController", description = "Sentinel模块API")
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @ApiOperation("查询")
    @GetMapping("/query")
    public CommonResult query(){
        return CommonResult.success("Sentinel");
    }
}
