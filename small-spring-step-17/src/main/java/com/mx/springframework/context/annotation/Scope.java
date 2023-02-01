package com.mx.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/30
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
