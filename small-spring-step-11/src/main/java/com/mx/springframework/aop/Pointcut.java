package com.mx.springframework.aop;


/**
 * Core Spring切入点抽象。
 * <p>
 * 切入点由 {@link ClassFilter} 和 {@link MethodMatcher} 组成。这些基本术语和Pointcut本身都可以组合起来构建组合
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public interface Pointcut {

    /**
     * 返回这个切入点的 ClassFilter。
     *
     * @return ClassFilter(从不为空)
     */
    ClassFilter getClassFilter();

    /**
     * 返回这个切入点的 MethodMatcher。
     *
     * @return MethodMatcher(从不为空)
     */
    MethodMatcher getMethodMatcher();
}
