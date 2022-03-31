package org.yangmy.tide.common.result;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangMingYang
 */
@RestControllerAdvice
public class ResponseResultAdvice implements ResponseBodyAdvice<Object> {

    public static ThreadLocal<Boolean> isResult=new ThreadLocal<>();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return isResult.get() != null?isResult.get():false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof Throwable){
            if(body instanceof BindException){
                BindException e=(BindException)body;
                BindingResult bindingResult=e.getBindingResult();
                Map<String,String> map=new HashMap<>();
                bindingResult.getFieldErrors().forEach((item)->{
                    map.put(item.getField(),item.getDefaultMessage());
                });
                return Result.FAILURE(Status.VALID,map);
            }
            Throwable e=(Throwable)body;
            return Result.FAILURE(Status.INTERNAL_ERROR,e.getMessage());
        }
        return Result.success(body);
    }
}
