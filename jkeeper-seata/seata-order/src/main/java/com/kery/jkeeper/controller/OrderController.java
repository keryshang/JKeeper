package com.kery.jkeeper.controller;

import com.kery.jkeeper.common.api.CommonResult;
import com.kery.jkeeper.domain.Order;
import com.kery.jkeeper.service.OrderService;
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

@Api(tags = "OrderController")
@Tag(name = "OrderController", description = "订单管理")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return CommonResult.success("订单创建成功!");
    }
}
