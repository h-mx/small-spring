package com.mx.springframework.tx.transaction;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public interface PlatformTransactionManager {

    TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;

    void commit(TransactionStatus status) throws TransactionException;

    void rollback(TransactionStatus status) throws TransactionException;
}
