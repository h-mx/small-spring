package com.mx.springframework.context.event;

import com.mx.springframework.context.ApplicationContext;
import com.mx.springframework.context.ApplicationEvent;

/**
 * 为 {@link ApplicationContext} 引发的事件的基类。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * 构造一个原型事件。
     *
     * @param source 事件最初发生的对象。
     * @throws IllegalArgumentException 如果source为空。
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取引发事件的 {@link ApplicationContext}。
     * @return
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
