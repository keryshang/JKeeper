package com.kery.jkeeper.common.execption;

import com.kery.jkeeper.common.api.IErrorCode;

/**
 * @author Kery
 * @Description: 断言处理类
 * @date 2023/9/25
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
