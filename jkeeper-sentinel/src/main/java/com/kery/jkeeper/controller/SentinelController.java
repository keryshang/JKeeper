package com.kery.jkeeper.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    private int num = 0;

    @ApiOperation("限流")
    @GetMapping("/flow")
    public CommonResult flow(){
        return CommonResult.success("Sentinel-Flow");
    }

    @ApiOperation("熔断降级")
    @GetMapping("/degrade")
    public CommonResult degrade(){
        num++;
        if(num%3 == 0){ //模拟服务异常
            throw  new RuntimeException();
        }
        return CommonResult.success("Sentinel-Degrade");
    }

}
