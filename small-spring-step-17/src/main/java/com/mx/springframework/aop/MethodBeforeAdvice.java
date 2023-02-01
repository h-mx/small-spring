package com.mx.springframework.aop;

import java.lang.reflect.Method;

/**
 * 在调用方法之前调用的通知。这样的通知不能阻止方法调用继续进行，除非它们抛出Throwable。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/13
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * 在调用给定方法之前调用。
     *
     * @param method 调用的方法
     * @param args   方法的参数
     * @param target 方法调用的目标。可能为空。
     * @throws Throwable 如果该对象希望中止调用。如果方法签名允许，抛出的任何异常都将返回给调用者。否则异常将被包装为运行时异常。
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
