package com.mx.springframework.beans.factory;

/**
 * 由 {@link BeanFactory} 中使用的对象实现的接口，这些对象本身就是工厂。如果一个bean实现了这个接口，那么它将被用作要公开的对象的工厂，而不是直接用作将自己公开的bean实例。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
