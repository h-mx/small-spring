package com.mx.springframework.test.config;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.config.BeanPostProcessor;
import com.mx.springframework.test.bean.IUserService;
import com.mx.springframework.test.bean.UserService2;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
public class UserServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (IUserService.class.isAssignableFrom(bean.getClass())) {
            return new UserService2();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
