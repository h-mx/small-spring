package com.mx.springframework;

import com.mx.springframework.bean.UserService;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "明星");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();

        System.out.println(userService == userService2);
    }
}
