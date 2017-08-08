package com.linchuanedu.edu.common.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoField.INSTANT_SECONDS;

/**
 * Created by pansp on 2017-8-4.
 */
public class TimeUtil {

    public static long getTimeStamp(){
        Instant timeStamp = Instant.now();
        return timeStamp.getLong(INSTANT_SECONDS);
    }

    public static String timeStampToDate(long second,String pattern){
        Instant timeStamp = Instant.ofEpochSecond(second);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern); //"yyyy-MM-DD HH:mm:ss"
        return formatter.format(ZonedDateTime.ofInstant(timeStamp, ZoneId.systemDefault()));
    }

    public static void main(String arg[]){
        System.out.println(timeStampToDate(1492753426,"yyyy-MM-dd HH:mm:ss"));
    }

}
