package com.mx.springframework.aop.aspectj;

import com.mx.springframework.aop.Pointcut;
import com.mx.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * Spring AOP Advisor，可用于任何AspectJ切入点表达式。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/13
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    @Override
    public Pointcut getPointcut() {
        if (null != pointcut) return pointcut;
        return new AspectJExpressionPointcut(expression);
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
