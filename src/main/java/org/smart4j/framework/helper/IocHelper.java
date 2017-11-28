package org.smart4j.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 *  依赖注入 助手类
 * @Author: houfy
 * @Description:
 * @Date: Created in $[TIME] $[DATE]
 * @Modified By:
 */
public final class IocHelper {

    static {
//        获取所有的Bean类与Bean实例直接的映射关系（Bean Map）
        Map<Class<?>,Object> beanmap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanmap)){
//            遍历BeanMap
            for(Map.Entry<Class<?>,Object> beanEntry:beanmap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
//                获取Bean类的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
//                    遍历beanFields
                    for(Field beanField: beanFields){
//                        判断当前Bean Field 是否带有Inject 注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanmap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }












    }













}
