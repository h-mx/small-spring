package com.mx.springframework.context.event;

import com.mx.springframework.context.ApplicationEvent;
import com.mx.springframework.context.ApplicationListener;

/**
 * 由对象实现的接口，这些对象可以管理许多 {@link ApplicationListener} 对象，并向它们发布事件。
 * <p>
 * 事件广播器
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加一个监听器来通知所有事件。
     *
     * @param listener 要添加的监听器
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 从通知列表中删除监听器。
     *
     * @param listener 要添加的监听器
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的应用程序事件多播到适当的监听器。
     *
     * @param event 要多播的监听器
     */
    void multicastEvent(ApplicationEvent event);
}
