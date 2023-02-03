package com.mx.springframework.tx.transaction.support;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public class DefaultTransactionStatus extends AbstractTransactionStatus{

    private final Object transaction;

    private final boolean newTransaction;

    public DefaultTransactionStatus(Object transaction, boolean newTransaction) {

        this.transaction = transaction;
        this.newTransaction = newTransaction;
    }

    @Override
    public boolean isNewTransaction() {
        return hasTransaction() && this.newTransaction;
    }

    public Object getTransaction() {
        return transaction;
    }

    public boolean hasTransaction() {
        return this.transaction != null;
    }

}
