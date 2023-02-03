package com.mx.springframework.tx.transaction.interceptor;

import java.io.Serializable;
import java.util.List;

/**
 * 对于指定的异常是否应该进行事务回滚
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public class RuleBasedTransactionAttribute extends DefaultTransactionAttribute implements Serializable {

    private List<RollbackRuleAttribute> rollbackRules;

    public RuleBasedTransactionAttribute() {
        super();
    }

    public void setRollbackRules(List<RollbackRuleAttribute> rollbackRules) {
        this.rollbackRules = rollbackRules;
    }
}
