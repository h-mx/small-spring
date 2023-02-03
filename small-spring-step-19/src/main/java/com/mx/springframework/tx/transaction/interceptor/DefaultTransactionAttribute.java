package com.mx.springframework.tx.transaction.interceptor;

import com.mx.springframework.tx.transaction.support.DefaultTransactionDefinition;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public class DefaultTransactionAttribute extends DefaultTransactionDefinition implements TransactionAttribute {
    public DefaultTransactionAttribute() {
        super();
    }

    @Override
    public boolean rollbackOn(Throwable ex) {
        return (ex instanceof RuntimeException || ex instanceof Error);
    }

    @Override
    public String toString() {
        return "DefaultTransactionAttribute{}";
    }
}
