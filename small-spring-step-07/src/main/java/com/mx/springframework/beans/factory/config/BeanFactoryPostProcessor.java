package com.mx.springframework.beans.factory.config;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改应用程序上下文的bean定义，调整上下文底层bean工厂的bean属性值。
 * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/9
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
