package annotation;

import java.lang.annotation.*;

/**
 * @author YangMingYang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
