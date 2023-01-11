package com.mx.springframework.context;

import java.util.EventListener;

/**
 * 由应用程序事件侦听器实现的接口。基于观察者设计模式的标准 {@link EventListener} 接口。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理应用程序事件。
     *
     * @param event 要响应的事件
     */
    void onApplicationEvent(E event);
}
