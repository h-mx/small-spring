package com.mx.springframework.beans.factory.config;

import com.mx.springframework.beans.BeansException;

/**
 * 允许自定义修改新bean实例的工厂钩子，例如。检查标记接口或用代理包装它们。
 * 提供了修改新实例化 Bean 对象的扩展点。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/9
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
