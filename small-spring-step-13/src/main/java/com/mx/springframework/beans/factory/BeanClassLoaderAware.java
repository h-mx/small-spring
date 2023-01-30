package com.mx.springframework.beans.factory;

/**
 * 回调，允许bean知道bean {@link ClassLoader } ;也就是说，当前bean工厂用来装入bean类的类装入器。
 * <p>
 * 实现此接口，既能感知到所属的 ClassLoader
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
