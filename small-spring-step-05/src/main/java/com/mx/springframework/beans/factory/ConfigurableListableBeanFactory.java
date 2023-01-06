package com.mx.springframework.beans.factory;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 配置接口将由大多数可列出的bean工厂实现。除了 {@link ConfigurableBeanFactory} 之外，它还提供了分析和修改bean定义以及预实例化单例的工具。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
