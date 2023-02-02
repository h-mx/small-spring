package com.mx.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Annotation at the field or method/constructor parameter level
 * that indicates a default value expression for the affe
 * <p>
 * 字段或方法/构造函数参数级别的注释，指示affe的默认值表达式
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * 实际值表达式: 例如 "#{systemProperties.myProp}".
     */
    String value();
}
