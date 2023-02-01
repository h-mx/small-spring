package com.mx.springframework.beans.factory.support;

import com.mx.springframework.core.io.DefaultResourceLoader;
import com.mx.springframework.core.io.ResourceLoader;

/**
 * 实现 {@link BeanDefinitionReader} 接口的 bean definition reader 的抽象基类
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
