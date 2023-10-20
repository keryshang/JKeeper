package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
@Api(tags = "StorageController")
@Tag(name = "StorageController", description = "库存管理")
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @GetMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return CommonResult.success("扣减库存成功！");
    }
}
