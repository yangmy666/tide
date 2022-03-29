package org.yangmy.tide.common.result;

import java.lang.annotation.*;

/**
 * <h1>前后端交互规范注解：</h1>
 * 该注解标记在类上代表该controller所有方法返回结果使用Result包装
 * 标注在方法上表示仅该方法返回结果使用Result包装
 * 类和方法同时标注仅类标注有效
 * @author YangMingYang
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {

    /**
     * 要排除的方法名称
     */
    String[] exclude() default {};
}
