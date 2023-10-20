package com.kery.jkeeper.service;

import com.kery.jkeeper.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
@FeignClient(value = "seata-account")
public interface AccountService {
    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
