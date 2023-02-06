package com.mx.springframework.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mx.springframework.aop.AdvisedSupport;
import com.mx.springframework.aop.TargetSource;
import com.mx.springframework.aop.framework.Cglib2AopProxy;
import com.mx.springframework.context.support.ClassPathXmlApplicationContext;
import com.mx.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.mx.springframework.jdbc.support.JdbcTemplate;
import com.mx.springframework.test.service.JdbcService;
import com.mx.springframework.test.service.impl.JdbcServiceImpl;
import com.mx.springframework.tx.transaction.annotation.AnnotationTransactionAttributeSource;
import com.mx.springframework.tx.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import com.mx.springframework.tx.transaction.interceptor.TransactionAttribute;
import com.mx.springframework.tx.transaction.interceptor.TransactionInterceptor;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.lang.reflect.Method;

public class ApiTest {

    private JdbcTemplate jdbcTemplate;

//    private JdbcService jdbcService;

    private DataSource dataSource;

    @Before
    public void init() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        dataSource = applicationContext.getBean(DruidDataSource.class);

//        jdbcService = applicationContext.getBean(JdbcServiceImpl.class);
    }

    @Test
    public void matchTransactionAnnotationTest() {
        JdbcService jdbcService = new JdbcServiceImpl();
        AnnotationTransactionAttributeSource transactionAttributeSource = new AnnotationTransactionAttributeSource();
        Method[] methods = jdbcService.getClass().getMethods();
        Method targetMethod = null;
        for (Method method : methods) {
            if (method.getName().equals("saveData")) {
                targetMethod = method;
                break;
            }
        }
        TransactionAttribute transactionAttribute = transactionAttributeSource.getTransactionAttribute(targetMethod, jdbcService.getClass());
        System.out.println(transactionAttribute.getName());
    }

    @Test
    public void jdbcWithTransaction() {

        JdbcService jdbcService = new JdbcServiceImpl();

        AnnotationTransactionAttributeSource transactionAttributeSource = new AnnotationTransactionAttributeSource();
        transactionAttributeSource.findTransactionAttribute(jdbcService.getClass());


        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        TransactionInterceptor interceptor = new TransactionInterceptor(transactionManager, transactionAttributeSource);

        BeanFactoryTransactionAttributeSourceAdvisor btas = new BeanFactoryTransactionAttributeSourceAdvisor();
        btas.setAdvice(interceptor);


        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(jdbcService));
        advisedSupport.setMethodInterceptor(interceptor);
        advisedSupport.setMethodMatcher(btas.getPointcut().getMethodMatcher());
        advisedSupport.setProxyTargetClass(false);

//        JdbcService proxy = (JdbcService)new ProxyFactory(advisedSupport).getProxy();
        JdbcService proxyCglib = (JdbcServiceImpl) new Cglib2AopProxy(advisedSupport).getProxy();


        proxyCglib.saveData(jdbcTemplate);
    }


}
