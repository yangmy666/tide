package annotation;

import java.lang.annotation.*;

/**
 * @描述： FruitName
 * @作者： YangMingYang
 * @日期： 2022/3/24-16:15
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
