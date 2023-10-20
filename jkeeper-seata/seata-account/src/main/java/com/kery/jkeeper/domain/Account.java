package com.kery.jkeeper.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
@Data
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
