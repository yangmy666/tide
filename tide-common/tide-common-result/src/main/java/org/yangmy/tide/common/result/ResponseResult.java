package org.yangmy.tide.common.result;

import java.lang.annotation.*;

/**
 * @author YangMingYang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
