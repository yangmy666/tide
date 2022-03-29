package org.yangmy.tide.common.result;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author YangMingYang
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod=(HandlerMethod) handler;
            Class<?> clazz=handlerMethod.getBeanType();
            Method method=handlerMethod.getMethod();
            //判断controller类上是否加了@ResponseResult
            if(clazz.isAnnotationPresent(ResponseResult.class)){
                ResponseResult responseResult=clazz.getAnnotation(ResponseResult.class);
                boolean isResult=true;
                String[] exclude=responseResult.exclude();
                if(exclude.length>0){
                    for (String s : exclude) {
                        if (method.getName().equals(s)) {
                            isResult = false;
                            break;
                        }
                    }
                }
                //添加包装返回结果标记
                ResponseResultAdvice.isResult.set(isResult);
            }
            //判断controller方法上是否加了@ResponseResult
            else if(method.isAnnotationPresent(ResponseResult.class)){
                //添加包装返回结果标记
                ResponseResultAdvice.isResult.set(true);
            }
        }
        return true;
    }
}
