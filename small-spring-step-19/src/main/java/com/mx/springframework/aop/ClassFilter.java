package com.mx.springframework.aop;

/**
 * 限制切入点或引入到给定目标类集的匹配的过滤器。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public interface ClassFilter {
    /**
     * 切入点是否应用于给定的接口或目标类
     *
     * @param clazz 候选目标类
     * @return 建议是否适用于给定的目标类
     */
    boolean matches(Class<?> clazz);

    ClassFilter TRUE = TrueClassFilter.INSTANCE;
}
