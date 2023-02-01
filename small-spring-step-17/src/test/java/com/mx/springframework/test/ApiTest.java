package com.mx.springframework.test;

import com.mx.springframework.context.support.ClassPathXmlApplicationContext;
import com.mx.springframework.core.convert.converter.Converter;
import com.mx.springframework.core.convert.support.StringToNumberConverterFactory;
import com.mx.springframework.test.bean.Husband;
import com.mx.springframework.test.converter.StringToIntegerConverter;
import org.junit.Test;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class ApiTest {

    @Test
    public void test_convert() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println("测试结果：" + husband);
    }

    @Test
    public void test_StringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("1234");
        System.out.println("测试结果：" + num);
    }

    @Test
    public void test_StringToNumberConverterFactory() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

        Converter<String, Integer> stringToIntegerConverter = converterFactory.getConverter(Integer.class);
        System.out.println("测试结果：" + stringToIntegerConverter.convert("1234"));

        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        System.out.println("测试结果：" + stringToLongConverter.convert("1234"));
    }

}
