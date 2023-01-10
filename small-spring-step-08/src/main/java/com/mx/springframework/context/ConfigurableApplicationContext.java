package com.mx.springframework.context;

import com.mx.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext 继承自 ApplicationContext，并提供了 refresh 这个核心方法。
 * 如果你有看过一些 Spring 源码，那么一定会看到这个方法。 接下来也是需要在上下文的实现中完成刷新容器的操作过程。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/9
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
