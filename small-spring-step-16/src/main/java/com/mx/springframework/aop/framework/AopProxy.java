package com.mx.springframework.aop.framework;

/**
 * 为已配置的AOP代理提供委托接口，允许创建实际的代理对象。
 * <p>
 * 开箱即用的实现可用于JDK动态代理和CGLIB代理，如DefaultAopProxyFactory应用的那样
 * <p>
 * AOP 代理的抽象
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public interface AopProxy {
    Object getProxy();
}
