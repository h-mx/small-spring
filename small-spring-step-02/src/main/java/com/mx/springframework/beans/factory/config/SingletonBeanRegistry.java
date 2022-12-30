package com.mx.springframework.beans.factory.config;

/**
 * 单例注册接口定义和实现
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public interface SingletonBeanRegistry {

    /**
     * 根据bean名字获取单例bean
     */
    Object getSingleton(String beanName);
}
