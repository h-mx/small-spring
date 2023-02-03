package com.mx.springframework.tx.transaction.support;

import com.mx.springframework.tx.transaction.NestedTransactionNotSupportedException;
import com.mx.springframework.tx.transaction.SavepointManager;
import com.mx.springframework.tx.transaction.TransactionException;
import com.mx.springframework.tx.transaction.TransactionStatus;

import java.io.IOException;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public abstract class AbstractTransactionStatus implements TransactionStatus {

    private boolean rollbackOnly = false;

    private boolean completed = false;

    private Object savepoint;

    @Override
    public boolean hasSavepoint() {
        return savepoint != null;
    }

    public void setSavepoint(Object savepoint) {
        this.savepoint = savepoint;
    }

    public Object getSavepoint() {
        return savepoint;
    }


    @Override
    public void setRollbackOnly() {
        this.rollbackOnly = true;
    }

    @Override
    public boolean isRollbackOnly() {
        return (isLocalRollbackOnly() || isGlobalRollbackOnly());
    }

    public boolean isLocalRollbackOnly() {
        return this.rollbackOnly;
    }

    public boolean isGlobalRollbackOnly() {
        return false;
    }


    @Override
    public void flush() throws IOException {

    }

    @Override
    public boolean isCompleted() {
        return completed;
    }


    //---------------------------------------------------------------------
    // Implementation of SavepointManager interface
    //---------------------------------------------------------------------


    @Override
    public Object createSavepoint() throws TransactionException {
        return getSavepointManager().createSavepoint();
    }

    @Override
    public void rollbackToSavepoint(Object savepoint) throws TransactionException {
        getSavepointManager().rollbackToSavepoint(savepoint);
    }

    @Override
    public void releaseSavepoint(Object savepoint) throws TransactionException {
        getSavepointManager().releaseSavepoint(savepoint);
    }

    protected SavepointManager getSavepointManager() {
        throw new NestedTransactionNotSupportedException("This transaction does not support savepoints");
    }

}
