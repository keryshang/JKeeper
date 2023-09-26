package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.service.FeignProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@Api(tags = "ConsumerController")
@Tag(name = "ConsumerController", description = "ConsumerFeign调用API")
@RestController
@RequestMapping("/feign")
public class ConsumerController {

    @Autowired
    private FeignProviderService feignProviderService;

    @ApiOperation("查询Provider服务名")
    @GetMapping("/queryProviderName")
    public CommonResult queryProviderName(){
        return feignProviderService.queryProviderName();
    }

}
