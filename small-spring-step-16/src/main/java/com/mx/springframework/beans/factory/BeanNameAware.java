package com.mx.springframework.beans.factory;

/**
 * 由bean实现的接口，这些bean希望知道它们在bean工厂中的bean名称。
 * <p>
 * 实现此接口，既能感知到所属的 BeanName
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String beanName);
}
