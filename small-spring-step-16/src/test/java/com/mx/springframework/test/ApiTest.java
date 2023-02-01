package com.mx.springframework.test;

import com.mx.springframework.context.support.ClassPathXmlApplicationContext;
import com.mx.springframework.test.bean.Husband;
import com.mx.springframework.test.bean.IWife;
import com.mx.springframework.test.bean.Wife;
import org.junit.Test;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class ApiTest {

    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        IWife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }

}
