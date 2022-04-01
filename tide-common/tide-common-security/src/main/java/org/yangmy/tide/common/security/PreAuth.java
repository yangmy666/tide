package org.yangmy.tide.common.security;

import java.lang.annotation.*;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuth {

    String value() default "";
}
