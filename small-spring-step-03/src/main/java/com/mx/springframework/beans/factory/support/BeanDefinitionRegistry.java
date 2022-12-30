package com.mx.springframework.beans.factory.support;

import com.mx.springframework.beans.factory.config.BeanDefinition;

/**
 * bean定义注册接口
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册bean的定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
