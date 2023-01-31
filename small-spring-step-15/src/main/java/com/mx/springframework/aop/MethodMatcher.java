package com.mx.springframework.aop;

import java.lang.reflect.Method;

/**
 * {@link Pointcut} 的一部分:检查目标方法是否有资格获得通知。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public interface MethodMatcher {

    /**
     * 执行静态检查给定方法是否匹配。If this
     *
     * @return 此方法是否静态匹配
     */
    boolean matches(Method method, Class<?> targetClass);
}
