package com.mx.springframework.tx.transaction.interceptor;

import com.mx.springframework.tx.transaction.support.DelegatingTransactionDefinition;

import java.io.Serializable;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public abstract class DelegatingTransactionAttribute extends DelegatingTransactionDefinition implements TransactionAttribute, Serializable {

    private final TransactionAttribute targetAttribute;

    public DelegatingTransactionAttribute(TransactionAttribute targetAttribute) {
        super(targetAttribute);
        this.targetAttribute = targetAttribute;
    }

    @Override
    public boolean rollbackOn(Throwable ex) {
        return this.targetAttribute.rollbackOn(ex);
    }
}
