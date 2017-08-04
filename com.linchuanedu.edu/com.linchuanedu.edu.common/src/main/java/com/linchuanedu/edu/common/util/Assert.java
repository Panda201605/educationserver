package com.linchuanedu.edu.common.util;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.exception.ErrorCode;

/**
 * Created by pansp on 2017-8-4.
 */
public class Assert {
    public static void assertNotEmpty(String param, String name) {
        if (param == null || param.isEmpty()) {
            throw new AppException(ErrorCode.INVALID_PARAMETER, name);
        }
    }
}
