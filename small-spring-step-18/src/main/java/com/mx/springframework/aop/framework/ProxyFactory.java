package com.mx.springframework.aop.framework;

import com.mx.springframework.aop.AdvisedSupport;

/**
 * Factory for AOP proxies for programmatic use, rather than via a bean
 * factory. This class provides a simple way of obtaining and configuring
 * AOP proxies in code.
 * <p>
 * 用于AOP代理的工厂，以供编程使用，而不是通过bean工厂。该类提供了一种在代码中获取和配置AOP代理的简单方法。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/13
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createPAopProxy().getProxy();
    }

    private AopProxy createPAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
