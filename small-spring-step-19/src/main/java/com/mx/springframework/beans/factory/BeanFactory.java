package com.mx.springframework.beans.factory;

import com.mx.springframework.beans.BeansException;

/**
 * bean工厂
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public interface BeanFactory {
    /**
     * 根据bean名字获取bean实例
     */
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;

    /**
     * 这个bean工厂是否包含具有给定名称的bean定义或外部注册的单例实例？
     * <p>
     * 如果给定的名称是别名，它将被转换回对应的规范bean名称。
     * 如果此工厂是分层的，将询问任何父工厂是否在此工厂实例中找不到bean。
     * 如果找到与给定名称匹配的bean定义或单例实例，则无论命名的bean定义是具体的还是抽象的，
     * 是懒惰的还是急切的，无论是否在范围内，此方法都将返回true。
     * <p>
     * 因此，请注意，此方法的真返回值不一定表示getBean能够获得相同名称的实例。
     *
     * @param name 要查询的bean的名称
     * @return 是否存在具有给定名称的bean
     */
    boolean containsBean(String name);
}
