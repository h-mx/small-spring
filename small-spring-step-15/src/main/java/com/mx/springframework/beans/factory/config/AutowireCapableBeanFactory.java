package com.mx.springframework.beans.factory.config;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.BeanFactory;

/**
 * {@link BeanFactory} 接口的扩展，由能够自动装配的bean工厂实现，前提是它们希望为现有bean实例公开此功能。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
