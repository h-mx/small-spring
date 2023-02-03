package com.mx.springframework.tx.transaction;

import java.io.Flushable;
import java.io.IOException;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public interface TransactionStatus extends SavepointManager, Flushable {

    /**
     * 是否开启新的事务
     */
    boolean isNewTransaction();

    boolean hasSavepoint();

    void setRollbackOnly();

    boolean isRollbackOnly();

    @Override
    void flush() throws IOException;

    boolean isCompleted();

}
