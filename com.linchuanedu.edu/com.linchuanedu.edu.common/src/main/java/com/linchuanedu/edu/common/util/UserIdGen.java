package com.linchuanedu.edu.common.util;

import java.util.Random;

/**
 * Created by pansp on 2017-8-4.
 */
public class UserIdGen {

    public static String newUserId(long timeStamp,String phone){
        String subTime = TimeUtil.timeStampToDate(timeStamp,"yyyyMMddHH");
        return subTime+phone.substring(7)+ new Random().nextInt(10);
    }

    public static void main(String arg[]){
        String test = newUserId(TimeUtil.getTimeStamp(),"15012345678");
        System.out.println(test);
    }
}
