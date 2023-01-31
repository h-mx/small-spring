package com.mx.springframework.beans.factory.annotation;


import cn.hutool.core.bean.BeanUtil;
import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.PropertyValues;
import com.mx.springframework.beans.factory.BeanFactory;
import com.mx.springframework.beans.factory.BeanFactoryAware;
import com.mx.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.mx.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.mx.springframework.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * {@link com.mx.springframework.beans.factory.config.BeanPostProcessor} implementation
 * that autowires annotated fields, setter methods and arbitrary config methods.
 * Such members to be injected are detected through a Java 5 annotation: by default,
 * Spring's {@link Autowired} and {@link Value} annotations.
 * <p>
 * 自动注入带注释的字段、setter方法和任意配置方法的 {@link com.mx.springframework.beans.factory.config.BeanPostProcessor} 实现。
 * 这些要注入的成员是通过Java 5注释检测的:默认情况下，是Spring的 {@link Autowired} 和 {@link Value} 注解。
 * <p>
 * 处理 @Value、@Autowired，注解的 BeanPostProcessor
 * <p>
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();
        // 1. 处理注解 @Value
        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (valueAnnotation != null) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (autowiredAnnotation != null) {
                Class<?> fieldType = field.getType();
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                String dependentBeanName = null;
                Object dependentBean = null;
                if (qualifierAnnotation != null) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }
}
