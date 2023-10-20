package com.kery.jkeeper.service;

import com.kery.jkeeper.domain.Order;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
