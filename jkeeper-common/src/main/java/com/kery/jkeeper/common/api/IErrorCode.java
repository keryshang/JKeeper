package com.kery.jkeeper.common.api;

/**
 * @author:: Kery
 * @description:
 * @date: 2023/9/20 13:21
 **/
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
