package com.mx.springframework.beans.factory;

import com.mx.springframework.beans.BeansException;

/**
 * 接口，由希望知道自己拥有 {@link BeanFactory} 的bean实现。
 * <p>
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
