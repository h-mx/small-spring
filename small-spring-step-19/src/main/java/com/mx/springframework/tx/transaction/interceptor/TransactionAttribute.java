package com.mx.springframework.tx.transaction.interceptor;

import com.mx.springframework.tx.transaction.TransactionDefinition;

/**
 * 直接看这个接口的名字含义是事务的属性。
 * 确实如此，这个接口继承TransactionDefine，添加了一个rollbackOn(Throwable ex)方法。
 * 在进行事务回滚前用来判断对于当前发生的异常是否需要回滚。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public interface TransactionAttribute extends TransactionDefinition {

    /**
     * 在进行事务回滚前用来判断对于当前发生的异常是否需要回滚。
     */
    boolean rollbackOn(Throwable ex);
}
