package org.yangmy.tide.common.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YangMingYang
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value= {BindException.class})
    public Result handleValidException(BindException e){
        log.info("数据校验出现异常{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult=e.getBindingResult();
        Map<String,String> map=new HashMap<>();
        bindingResult.getFieldErrors().forEach((item)->{
            map.put(item.getField(),item.getDefaultMessage());
        });
        return Result.warning("参数校验错误",map);
    }

    @ExceptionHandler(value= {ValidationException.class})
    public Result handleValidException(ValidationException e){
        log.info("数据校验出现异常{}，异常类型：{}",e.getMessage(),e.getClass());
        return Result.warning("参数校验错误",e.getMessage());
    }

    @ExceptionHandler(value= Throwable.class)
    public Result handleException(Throwable e){
        log.error("服务器内部错误{}，异常类型：{}",e.getMessage(),e.getClass());
        return Result.failure("服务器内部错误",e.getMessage());
    }

}
