package com.mx.springframework.beans.factory.config;

/**
 * bean定义
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
