package org.smart4j.framework.test;


import org.junit.Test;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ConfigHelper;
import org.smart4j.framework.util.ClassUtil;

/**
 *
 */
public class ClassHelperTest {



    @Test
    public void testGetClassSet(){
        System.out.println(ClassHelper.getClassSet().size());
        System.out.println(ClassHelper.getClassSet());
    }

    @Test
    public void testGetControllerClassSet(){
        System.out.println(ClassHelper.getControllerClassSet().size());
        System.out.println(ClassHelper.getControllerClassSet());
    }

    @Test
    public void testGetServiceClassSet(){
        System.out.println(ClassHelper.getServiceClassSet().size());
        System.out.println(ClassHelper.getServiceClassSet());
    }

    @Test
    public void testGetBeanClassSet(){
        System.out.println(ClassHelper.getBeanrClassSet().size());
        System.out.println(ClassHelper.getBeanrClassSet());
    }












}
