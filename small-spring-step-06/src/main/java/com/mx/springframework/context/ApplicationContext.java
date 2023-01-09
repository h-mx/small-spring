package com.mx.springframework.context;

import com.mx.springframework.beans.factory.ListableBeanFactory;

/**
 * ApplicationContext，继承于 ListableBeanFactory，也就继承了关于 BeanFactory 方法，比如一些 getBean 的方法。
 * 另外 ApplicationContext 本身是 Central 接口，但目前还不需要添加一些获取ID和父类上下文，所以暂时没有接口方法的定义。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/9
 */
public interface ApplicationContext extends ListableBeanFactory {
}
