package com.mx.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.mx.springframework.stereotype.Component;

import java.util.Set;

/**
 * A bean definition scanner that detects bean candidates on the classpath,
 * registering corresponding bean definitions with a given registry ({@link com.mx.springframework.beans.factory.BeanFactory}
 * or {@link com.mx.springframework.context.ApplicationContext}).
 * <p>
 * 一个bean定义扫描器，用于检测类路径上的候选bean，将相应的bean定义注册到给定的注册中心({@link com.mx.springframework.beans.factory.BeanFactory}
 * 或 {@link com.mx.springframework.context.ApplicationContext}).。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/30
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String scope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(scope)) {
                    beanDefinition.setScope(scope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (scope != null) return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value;
        if (component == null || StrUtil.isEmpty(value = component.value())) {
            return StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
