package com.mx.springframework.context;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.Aware;

/**
 * 由任何对象实现的接口，该对象希望得到它所运行的 {@link ApplicationContext} 的通知。
 * <p>
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
