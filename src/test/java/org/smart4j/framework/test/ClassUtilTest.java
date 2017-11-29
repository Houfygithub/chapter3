package org.smart4j.framework.test;


import org.junit.Assert;
import org.junit.Test;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.ClassUtil;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

public class ClassUtilTest {


    @Test
    public void testLoadClass(){
        Class<?> clsObj = null;
        clsObj = ClassUtil.loadClass("org.smart4j.framework.util.ArrayUtil",false);
        Assert.assertNotNull(clsObj);
    }

    @Test
    public void testGetClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet = ClassUtil.getClassSet("org.smart4j.framework.util");
        System.out.println(classSet);
    }
}
