package com.mx.springframework.aop;

import com.mx.springframework.util.ClassUtils;

/**
 * TargetSource用于获取AOP调用的当前 "target"，如果没有 around 通知选择结束拦截器链本身，将通过反射调用该 "target"。
 * <p>
 * 被代理的目标对象
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 返回由这个 {@link TargetSource} 返回的目标类型。
     * 可以返回 null，尽管 {@link TargetSource} 的某些用法可能只适用于预定的目标类。
     *
     * @return 这个 {@link TargetSource} 返回的目标的类型
     */
    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    /**
     * 返回一个目标实例。在 AOP 框架调用 AOP 方法调用的 "target" 之前立即调用。
     *
     * @return target 对象，其中包含 joinPoint
     * @throws Exception 如果目标对象无法解析
     */
    public Object getTarget() {
        return target;
    }
}
