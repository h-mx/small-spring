package com.mx.springframework.beans.factory.support;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.FactoryBean;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.beans.factory.config.BeanPostProcessor;
import com.mx.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.mx.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象bean工厂
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /**
     * 在createBean中应用BeanPostProcessors
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * ClassLoader来解析 bean 类名，如果需要的话
     */
    private final ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override

    public Object getBean(String beanName) throws BeansException {
        return deGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return deGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    protected <T> T deGetBean(final String beanName, final Object[] args) {
        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    /**
     * 根据bean名字获取bean定义
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建bean实例
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            object = getObjectFromFactoryBean((FactoryBean<?>) beanInstance, beanName);
        }
        return object;
    }


    /**
     * 返回将应用于用该工厂创建的bean的BeanPostProcessors列表。
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }
}
