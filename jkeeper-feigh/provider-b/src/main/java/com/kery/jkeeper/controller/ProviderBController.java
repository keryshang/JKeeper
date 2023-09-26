package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@RestController()
@RequestMapping("/feign")
public class ProviderBController {

    @GetMapping("/queryProviderName")
    public CommonResult queryProviderName(){
        return CommonResult.success("provider-b");
    }
}
