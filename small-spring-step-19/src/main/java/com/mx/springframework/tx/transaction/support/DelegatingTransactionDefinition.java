package com.mx.springframework.tx.transaction.support;

import com.mx.springframework.tx.transaction.TransactionDefinition;

import java.io.Serializable;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public abstract class DelegatingTransactionDefinition implements TransactionDefinition, Serializable {

    private final TransactionDefinition targetDefinition;

    public DelegatingTransactionDefinition(TransactionDefinition targetDefinition) {
        this.targetDefinition = targetDefinition;
    }

    @Override
    public int getPropagationBehavior() {
        return targetDefinition.getPropagationBehavior();
    }

    @Override
    public int getIsolationLevel() {
        return targetDefinition.getIsolationLevel();
    }

    @Override
    public int getTimeout() {
        return targetDefinition.getTimeout();
    }

    @Override
    public boolean isReadOnly() {
        return targetDefinition.isReadOnly();
    }

    @Override
    public String getName() {
        return targetDefinition.getName();
    }

    @Override
    public boolean equals(Object other) {
        return this.targetDefinition.equals(other);
    }

    @Override
    public int hashCode() {
        return this.targetDefinition.hashCode();
    }

    @Override
    public String toString() {
        return this.targetDefinition.toString();
    }
}
