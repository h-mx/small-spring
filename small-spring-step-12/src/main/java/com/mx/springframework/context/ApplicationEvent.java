package com.mx.springframework.context;

import java.util.EventObject;

/**
 * 由所有应用程序事件扩展的类。抽象，因为直接发布一般事件没有意义。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * 构造一个原型事件。
     *
     * @param source 事件最初发生的对象。
     * @throws IllegalArgumentException 如果source为空。
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
