package com.mx.springframework.beans.factory.support;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.core.io.Resource;
import com.mx.springframework.core.io.ResourceLoader;

/**
 * bean definition reader 的简单接口。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
