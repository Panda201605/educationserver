package com.linchuanedu.edu.common.exception;

/**
 * Created by pansp on 2017-8-3.
 */
public enum ErrorCode {
    BAD_REQUEST("401", "bad request");

    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
