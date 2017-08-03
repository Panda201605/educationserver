package com.linchuanedu.edu.common.exception;

import java.text.MessageFormat;

/**
 * Created by pansp on 2017-8-3.
 */
public class AppException extends RuntimeException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode, Object... arguments) {
        super(MessageFormat.format(errorCode.getMsg(), arguments));
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
