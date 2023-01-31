package com.mx.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * 包含AOP通知(在连接点执行的操作)的基本接口和决定通知适用性的过滤器(例如切入点)。
 * 这个接口不是供Spring用户使用的，而是为了支持不同类型的通知。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/13
 */
public interface Advisor {
    /**
     * 返回此 aspect 的 advice 部分。一个 advice 可以是一个拦截器，一个 before advice，一个 throws advice，等等。
     *
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
