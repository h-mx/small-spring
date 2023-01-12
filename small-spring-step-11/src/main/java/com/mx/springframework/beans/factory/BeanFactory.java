package com.mx.springframework.beans.factory;

import com.mx.springframework.beans.BeansException;

/**
 * bean工厂
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public interface BeanFactory {
    /**
     * 根据bean名字获取bean实例
     */
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
