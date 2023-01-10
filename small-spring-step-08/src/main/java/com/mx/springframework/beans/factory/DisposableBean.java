package com.mx.springframework.beans.factory;

/**
 * 由希望在销毁时释放资源的bean实现的接口。如果BeanFactory处理一个缓存的单例，它应该调用destroy方法。应用程序上下文应该在关闭时处理它的所有单例对象。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/10
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
