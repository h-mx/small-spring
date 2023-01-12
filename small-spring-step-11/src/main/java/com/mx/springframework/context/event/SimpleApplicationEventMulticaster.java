package com.mx.springframework.context.event;

import com.mx.springframework.beans.factory.BeanFactory;
import com.mx.springframework.context.ApplicationEvent;
import com.mx.springframework.context.ApplicationListener;

/**
 * {@link ApplicationEventMulticaster} 接口的简单实现。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/11
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener<ApplicationEvent> listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
