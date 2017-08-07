package com.linchuanedu.edu.common.exception;

/**
 * Created by pansp on 2017-8-3.
 */
public enum ErrorCode {
    BAD_REQUEST("401", "bad request"),
    INVALID_PARAMETER("600", "{0} should no be empty!"),
    USER_ALREADY_EXISTS("601","The user already exists!"),
    ACCOUNT_PASSWORD_INCORRECT("602","The account or password not incorrect"),
    ID_INCORRECT("603","The userId incorrect!"),
    PERMISSION_DENIED("604","Do not have permission")
    ;

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
