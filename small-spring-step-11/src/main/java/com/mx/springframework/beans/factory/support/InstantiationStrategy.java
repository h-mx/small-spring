package com.mx.springframework.beans.factory.support;

import com.mx.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args);

}
