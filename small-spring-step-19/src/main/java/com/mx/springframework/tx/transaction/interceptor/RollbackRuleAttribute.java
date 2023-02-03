package com.mx.springframework.tx.transaction.interceptor;

import java.io.Serializable;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public class RollbackRuleAttribute implements Serializable {
    private final String exceptionName;

    public RollbackRuleAttribute(Class<?> clazz) {
        this.exceptionName = clazz.getName();
    }

}
