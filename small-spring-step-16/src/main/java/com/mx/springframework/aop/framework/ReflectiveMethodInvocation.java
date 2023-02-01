package com.mx.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * 使用反射调用目标对象。子类可以重写  #invokeJoinpoint() 方法来改变这种行为，因此对于更专门的 {@link MethodInvocation} 实现来说，这也是一个有用的基类。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    // 目标对象
    protected final Object target;
    // 方法
    protected final Method method;
    // 入参
    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
