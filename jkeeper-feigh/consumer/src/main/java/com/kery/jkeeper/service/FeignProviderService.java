package com.kery.jkeeper.service;

import com.kery.jkeeper.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@FeignClient("provider")
public interface FeignProviderService {

    @GetMapping("/feign/queryProviderName")
    CommonResult queryProviderName();
}
