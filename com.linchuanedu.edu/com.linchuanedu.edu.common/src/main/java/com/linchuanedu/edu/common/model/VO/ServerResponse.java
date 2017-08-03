package com.linchuanedu.edu.common.model.VO;

/**
 * Created by pansp on 2017-8-3.
 */
public class ServerResponse<T> {
    private String code = "200";
    private String msg = "success";
    private T data;

    public ServerResponse(T data) {
        this.data = data;
    }

    public ServerResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServerResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> successWithData(T data) {
        return new ServerResponse(data);
    }

    public static ServerResponse failureWithCodeMsg(String code, String msg) {
        return new ServerResponse(code, msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
