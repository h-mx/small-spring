package com.mx.springframework.beans.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a constructor, field, setter method or config method as to be
 * autowired by Spring's dependency injection facilities.
 * <p>
 * 将构造函数、字段、setter方法或配置方法标记为由Spring的依赖注入工具自动连接。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
public @interface Autowired {
}
