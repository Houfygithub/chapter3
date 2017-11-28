package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * @Author: houfy
 * @Description:
 * @Date: Created in $[TIME] $[DATE]
 * @Modified By:
 */

    /**
    * 判断数组 是否为空
    */
    public final class ArrayUtil {
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组 是否非空
     */
    public static boolean isNotEmpty(Object[] array){
        return !isEmpty(array);
    }
}

