package com.linchuanedu.edu.common.util;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.exception.ErrorCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pansp on 2017-8-4.
 */
public class Assert {

    public static void assertNotEmpty(String param, String name) {
        if (param == null || param.isEmpty()) {
            throw new AppException(ErrorCode.INVALID_PARAMETER, name);
        }
    }

    public static void assertIsNumeric(String param, String name){
        Pattern pattern = Pattern.compile("^[1-9][0-9]*");
        Matcher matcher = pattern.matcher(param);

        if(!matcher.matches()){
            throw new AppException(ErrorCode.INVALID_PARAMETER, name);
        }
    }
}
