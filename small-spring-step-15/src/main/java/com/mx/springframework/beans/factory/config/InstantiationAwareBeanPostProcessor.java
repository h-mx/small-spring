package com.mx.springframework.beans.factory.config;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.PropertyValues;

/**
 * Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * and a callback after instantiation but before explicit properties are set or
 * autowiring occurs.
 * <p>
 * BeanPostProcessor的子接口，它添加实例化前回调和实例化后但显式属性设置或自动装配发生之前的回调
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/13
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     * <p>
     * 在目标bean实例化之前应用这个BeanPostProcessor。返回的bean对象可以是代替目标bean使用的代理，有效地抑制了目标bean的默认实例化。
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * Perform operations after the bean has been instantiated, via a constructor or factory method,
     * but before Spring property population (from explicit properties or autowiring) occurs.
     * <p>This is the ideal callback for performing field injection on the given bean instance.
     * See Spring's own {@link com.mx.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     * for a typical example.
     * <p>
     * 在bean实例化之后(通过构造函数或工厂方法)，但在Spring属性填充(从显式属性或自动装配)发生之前执行操作。
     * 这是在给定bean实例上执行字段注入的理想回调。有关典型示例，请参阅Spring自己的 {@link com.mx.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     * <p>
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * Post-process the given property values before the factory applies them
     * to the given bean. Allows for checking whether all dependencies have been
     * satisfied, for example based on a "Required" annotation on bean property setters.
     * <p>
     * 在工厂将给定的属性值应用到给定的bean之前，对它们进行后处理。
     * 允许检查是否满足了所有依赖项，例如基于bean属性设置符上的“Required”注释。
     * <p>
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;
}
