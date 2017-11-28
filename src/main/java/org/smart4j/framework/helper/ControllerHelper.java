package org.smart4j.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import sun.util.locale.provider.LocaleServiceProviderPool;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器 助手类
 */
public final class ControllerHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);

    /**
     * 存放请求与处理器的映射关系（Action Map)
     */
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
//            遍历Controller类
            for (Class<?> controllerClass:controllerClassSet){
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
//                    遍历Controller类中的方法
                    for(Method method:methods){
                        if(method.isAnnotationPresent(Action.class)){
//                            从Action注解中 获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
//                            验证URL 映射规则
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                                    String requstMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requstMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requstMethod, String requestPath){
        Request request = new Request(requstMethod,requestPath);
        if(!ACTION_MAP.containsKey(request)){
            LOGGER.error("can not find request handler.");
        }
        return ACTION_MAP.get(request);
    }

}
