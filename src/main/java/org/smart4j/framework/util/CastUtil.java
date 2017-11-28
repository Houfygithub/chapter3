package org.smart4j.framework.util;


/**
 * Created by Houfy on 2017/11/22.
 *
 * 类型转换 工具类
 */
public final class CastUtil {

    /**
     *  转换为 String
     */
    public static String castString(Object obj){
        return castString(obj,"");
    }
    /**
     *  转换为 String(提供默认值)
     */
    public static String castString(Object obj, String defaultValue){
        return obj != null ? String.valueOf(obj):defaultValue;
    }

    /**
     *  转换为 double型
     */
    public static double castDouble(Object obj){
        return castDouble(obj,0);
    }
    /**
     *  转换为 double型(指定默认值)
     */
    public static double castDouble(Object obj, double defaultValue){
        double doubleValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     *  转换为 long型
     */
    public static long castLong(Object obj){
        return castLong(obj,0);
    }
    /**
     *  转换为 long型(指定默认值)
     */
    public static long castLong(Object obj,long defaultValue){
        long longValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     *  转换为 int型
     */
    public static int castInt(Object obj){
        return castInt(obj,0);
    }
    /**
     *  转换为 int型(指定默认值)
     */
    public static int castInt(Object obj, int defaultValue){
        int intVallue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    intVallue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intVallue = defaultValue;
                }
            }
        }
        return intVallue;
    }


    /**
     *  转换为 boolean型
     */
    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }
    /**
     *  转换为 boolean型(指定默认值)
     */
    public static boolean castBoolean(Object obj, boolean defaultValue){
        boolean value = defaultValue;
        if(obj != null){
            value = Boolean.parseBoolean(castString(obj));
        }
        return value;
    }


}
