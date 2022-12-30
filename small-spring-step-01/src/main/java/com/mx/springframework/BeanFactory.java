package com.mx.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
