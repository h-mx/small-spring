package com.mx.springframework;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
