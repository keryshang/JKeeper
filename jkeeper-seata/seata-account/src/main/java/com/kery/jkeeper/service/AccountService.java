package com.kery.jkeeper.service;

import java.math.BigDecimal;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
