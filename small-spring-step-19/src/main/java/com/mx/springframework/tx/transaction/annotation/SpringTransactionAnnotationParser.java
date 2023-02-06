package com.mx.springframework.tx.transaction.annotation;

import com.mx.springframework.core.annotation.AnnotatedElementUtils;
import com.mx.springframework.core.annotation.AnnotationAttributes;
import com.mx.springframework.tx.transaction.interceptor.RollbackRuleAttribute;
import com.mx.springframework.tx.transaction.interceptor.RuleBasedTransactionAttribute;
import com.mx.springframework.tx.transaction.interceptor.TransactionAttribute;

import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/3
 */
public class SpringTransactionAnnotationParser implements TransactionAnnotationParser, Serializable {

//    @Override
//    public TransactionAttribute parseTransactionAnnotation(AnnotatedElement element) {
//        Transactional transactional = element.getAnnotation(Transactional.class);
//        if (transactional == null) return null;
//
//        RuleBasedTransactionAttribute rbta = new RuleBasedTransactionAttribute();
//        ArrayList<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
//        Class<? extends Throwable>[] rbRules = transactional.rollbackFor();
//        if (rbRules == null) {
//            return rbta;
//        }
//        for (Class<?> rbRule : transactional.rollbackFor()) {
//            rollbackRules.add(new RollbackRuleAttribute(rbRule));
//        }
//        rbta.setRollbackRules(rollbackRules);
//        return rbta;
//    }

    @Override
    public TransactionAttribute parseTransactionAnnotation(AnnotatedElement element) {
        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(element, Transactional.class, false, false);
        if (attributes != null) {
            return parseTransactionAnnotation(attributes);
        }
        return null;
    }

    protected TransactionAttribute parseTransactionAnnotation(AnnotationAttributes attributes) {
        RuleBasedTransactionAttribute rbta = new RuleBasedTransactionAttribute();
        ArrayList<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
        for (Class<?> rbRule : attributes.getClassArray("rollbackFor")) {
            rollbackRules.add(new RollbackRuleAttribute(rbRule));
        }
        rbta.setRollbackRules(rollbackRules);
        return rbta;
    }
}
