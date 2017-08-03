package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pansp
 * Date: 2017-7-21
 * Time: 15:52
 */

public class AbstractController {

    @ExceptionHandler(AppException.class)
    protected ServerResponse handleBASException(AppException e, HttpServletRequest request) {
        ServerResponse serverResponse = ServerResponse.failureWithCodeMsg(e.getErrorCode().getCode(), e.getMessage());
        return serverResponse;
    }

}
