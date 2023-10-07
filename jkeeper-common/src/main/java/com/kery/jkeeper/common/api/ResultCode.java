package com.kery.jkeeper.common.api;

import lombok.Getter;

/**
 * @author:: Kery
 * @description: 常用API返回结果
 * @date: 2023/9/20 13:21
 **/
@Getter
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    final private long code;
    final private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
