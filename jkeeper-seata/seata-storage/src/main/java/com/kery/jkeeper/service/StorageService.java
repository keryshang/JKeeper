package com.kery.jkeeper.service;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
