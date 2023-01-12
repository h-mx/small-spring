package com.mx.springframework.beans.factory.config;

/**
 * bean引用
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/3
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
