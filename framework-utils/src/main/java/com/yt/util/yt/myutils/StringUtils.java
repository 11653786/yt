package com.yt.util.yt.myutils;

/**
 * Created by user on 2015/8/20.
 */
public class StringUtils {

    public static boolean checkNotNull(Object obj){
        if(obj!=null && !obj.equals("")){
                return true;
        }
        return false;
    }
}
