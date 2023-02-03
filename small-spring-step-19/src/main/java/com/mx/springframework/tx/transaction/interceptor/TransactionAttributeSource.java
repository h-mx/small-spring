package com.mx.springframework.tx.transaction.interceptor;

import java.lang.reflect.Method;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public interface TransactionAttributeSource {

    TransactionAttribute getTransactionAttribute(Method method,Class<?> targetClass);
}
