package com.mx.springframework.context;

/**
 * 封装事件发布功能的接口。作为ApplicationContext的超级接口。
 * <p>
 * 事件发布者接口
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public interface ApplicationEventPublisher {
    /**
     * 将应用程序事件通知此应用程序注册的所有侦听器。
     * 事件可以是框架事件(如RequestHandledEvent)或特定于应用程序的事件。
     *
     * @param event 要发布的事件
     */
    void publishEvent(ApplicationEvent event);
}
