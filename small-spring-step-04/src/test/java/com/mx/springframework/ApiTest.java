package com.mx.springframework;

import com.mx.springframework.bean.UserDao;
import com.mx.springframework.bean.UserService;
import com.mx.springframework.beans.PropertyValue;
import com.mx.springframework.beans.PropertyValues;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.beans.factory.config.BeanReference;
import com.mx.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

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
        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性[userId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        // 4. UserService 注入bean
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
        //  5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }


    @Test
    public void test1() {
        System.out.println((new BigDecimal("11.00").compareTo(new BigDecimal("10.00"))) <= 0);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        System.out.println(map);
    }
}
