package com.mx.springframework.beans.factory;

import com.mx.springframework.beans.BeansException;

/**
 * 定义一个工厂，该工厂在调用时可以返回Object实例(可能是共享的或独立的)。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
