package com.mx.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * This annotation may be used on a field or parameter as a qualifier for
 * candidate beans when autowiring. It may also be used to annotate other
 * custom annotations that can then in turn be used as qualifiers.
 * <p>
 * 在自动装配时，此注释可用于字段或参数，作为候选bean的限定符。
 * 它还可以用于注释其他自定义注释，然后这些自定义注释又可以用作限定符。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
