package com.kery.jkeeper.domain;

import lombok.Data;

/**
 * Description:
 * Author: Kery
 * Date: 2023/10/20
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
