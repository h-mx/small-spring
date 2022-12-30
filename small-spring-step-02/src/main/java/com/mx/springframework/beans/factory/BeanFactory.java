package com.mx.springframework.beans.factory;

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
    Object getBean(String beanName);
}
