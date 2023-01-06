package com.mx.springframework.beans.factory;

import com.mx.springframework.beans.BeansException;

import java.util.Map;

/**
 * bean工厂实现的BeanFactory接口的扩展，可以枚举其所有bean实例，而不是按客户端请求逐个按名称尝试bean查找。
 * 预加载所有bean定义的BeanFactory实现(例如基于xml的工厂)可以实现此接口。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
