package com.mx.springframework.context.event;

import com.mx.springframework.context.ApplicationContext;

/**
 * 当 {@link ApplicationContext} 初始化或刷新时引发的事件。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * 构造一个原型事件。
     *
     * @param source 事件最初发生的对象。
     * @throws IllegalArgumentException 如果source为空。
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
