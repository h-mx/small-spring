package com.mx.springframework.beans.factory.config;

import com.mx.springframework.beans.factory.BeanFactory;
import com.mx.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 配置接口被大多数bean工厂实现。除了 {@link BeanFactory} 中的bean工厂客户端方法外，还提供配置bean工厂的工具
 * <p>
 * 可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
