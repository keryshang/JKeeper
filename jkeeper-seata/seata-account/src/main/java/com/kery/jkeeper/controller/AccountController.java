package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
@Api(tags = "AccountController")
@Tag(name = "AccountController", description = "账户管理")
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @GetMapping("/decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
        accountService.decrease(userId,money);
        return CommonResult.success("扣减账户余额成功！");
    }
}
