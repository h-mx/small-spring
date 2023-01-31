package com.mx.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A component provider that scans the classpath from a base package. It then
 * applies exclude and include filters to the resulting classes to find candidates.
 * <p>
 * 从基本包扫描类路径的组件提供程序。然后，它对结果类应用排除和包括过滤器来查找候选类。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/30
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        LinkedHashSet<BeanDefinition> candidates = new LinkedHashSet<>();
        for (Class<?> clazz : ClassUtil.scanPackageByAnnotation(basePackage, Component.class)) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
