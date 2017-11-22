package org.smart4j.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Houfy on 2017/11/21.
 *
 *  属性文件工具类
 */
public class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);


    /**
     *  加载属性文件
     */
    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null ){
                throw new FileNotFoundException(fileName + " file is not found.");
            }

            properties = new Properties();
            properties.load(is);

        }catch (IOException e){
            LOGGER.error("load properties file failure",e);
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return properties;
    }

    /**
     *  获取字符型属性（默认值为空串）
     */
    public static String getString(Properties props, String key){
        return null;
    }









}
