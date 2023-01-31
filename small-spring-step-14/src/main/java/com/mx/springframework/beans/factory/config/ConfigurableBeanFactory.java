package com.mx.springframework.beans.factory.config;

import com.mx.springframework.beans.factory.BeanFactory;
import com.mx.springframework.beans.factory.HierarchicalBeanFactory;
import com.mx.springframework.util.StringValueResolver;

/**
 * 配置接口被大多数bean工厂实现。除了 {@link BeanFactory} 中的bean工厂客户端方法外，还提供配置bean工厂的工具
 * <p>
 * 可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    /**
     * 为嵌入的值(如注释属性)添加一个String解析器。
     *
     * @param valueResolver 字符串解析器应用于嵌入的值
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * 解析给定的嵌入值，例如注释属性。
     *
     * @param value 要解析的值
     * @return 解析值(可能是原始值)
     */
    String resolveEmbeddedValue(String value);
}
