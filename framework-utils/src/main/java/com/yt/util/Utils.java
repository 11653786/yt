package com.yt.util;

/**
 * Created by user on 2015/8/20.
 */
public class Utils {

    public static boolean CheckNotNull(Object obj){
        if(obj!=null && !obj.equals("")){
                return true;
        }
        return false;
    }
}
