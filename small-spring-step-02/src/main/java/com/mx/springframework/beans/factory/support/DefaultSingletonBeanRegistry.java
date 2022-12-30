package com.mx.springframework.beans.factory.support;

import com.mx.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SingletonBeanRegistry的默认实现
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * bean单例池
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例对象
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
