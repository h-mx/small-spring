package com.mx.springframework.tx.transaction.annotation;

import java.lang.annotation.*;

/**
 * 这是作用于方法和类上的标识注解。标识该方法或者该类中的方法应用事务。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Transactional {
    Class<? extends Throwable>[] rollbackFor() default {};
}
