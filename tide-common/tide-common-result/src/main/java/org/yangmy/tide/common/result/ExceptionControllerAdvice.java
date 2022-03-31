package org.yangmy.tide.common.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YangMingYang
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value= BindException.class)
    public BindException handleValidException(BindException e){
        log.error("数据校验出现异常{}，异常类型：{}",e.getMessage(),e.getClass());
        return e;
    }

    @ExceptionHandler(value= Throwable.class)
    public Throwable handleException(Throwable e){
        log.error("服务器内部错误{}，异常类型：{}",e.getMessage(),e.getClass());
        return e;
    }

}
