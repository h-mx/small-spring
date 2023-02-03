package com.mx.springframework.tx.transaction.annotation;

import com.mx.springframework.tx.transaction.interceptor.TransactionAttribute;

import java.lang.reflect.AnnotatedElement;

/**
 * 解析方法或者类上的注解得到事务的属性。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public interface TransactionAnnotationParser {
    /**
     * 解析 事务注解
     */
    TransactionAttribute parseTransactionAnnotation(AnnotatedElement element);
}
