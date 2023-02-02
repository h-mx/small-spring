package com.mx.springframework.context.support;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.mx.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.mx.springframework.beans.factory.config.BeanPostProcessor;
import com.mx.springframework.context.ApplicationContext;
import com.mx.springframework.context.ApplicationEvent;
import com.mx.springframework.context.ApplicationListener;
import com.mx.springframework.context.ConfigurableApplicationContext;
import com.mx.springframework.context.event.ApplicationEventMulticaster;
import com.mx.springframework.context.event.ContextClosedEvent;
import com.mx.springframework.context.event.ContextRefreshedEvent;
import com.mx.springframework.context.event.SimpleApplicationEventMulticaster;
import com.mx.springframework.core.convert.ConversionService;
import com.mx.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象应用上下文
 * <p>
 * {@link ApplicationContext} 接口的抽象实现。不强制配置使用的存储类型;简单地实现公共上下文功能。使用模板方法设计模式，需要具体的子类来实现抽象方法。
 * <p>
 * AbstractApplicationContext 继承 DefaultResourceLoader 是为了处理 spring.xml 配置资源的加载。
 * <p>
 * 之后是在 refresh() 定义实现过程，包括：
 * 1.创建 BeanFactory，并加载 BeanDefinition
 * 2.获取 BeanFactory
 * 3.在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
 * 4.BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
 * 5.提前实例化单例Bean对象
 * <p>
 * 另外把定义出来的抽象方法，refreshBeanFactory()、getBeanFactory() 由后面的继承此抽象类的其他抽象类实现。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/9
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();
        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6. 初始化事件发布者
        initApplicationEventMulticaster();
        // 7. 注册事件监听器
        registerListeners();
        // 8. 设置类型转换器、提前实例化单例Bean对象
        finishBeanFactoryInitialization(beanFactory);
        // 9. 发布容器刷新完成事件
        finishRefresh();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));

        getBeanFactory().destroySingletons();
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public boolean containsBean(String name) {
        return getBeanFactory().containsBean(name);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }


    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        for (ApplicationListener<?> listener : getBeansOfType(ApplicationListener.class).values()) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    /**
     * 设置类型转换器、提前实例化单例Bean对象
     */
    protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
        // 设置类型转换器
        if (beanFactory.containsBean("conversionService")) {
            Object conversionService = beanFactory.getBean("conversionService");
            if (conversionService instanceof ConversionService) {
                beanFactory.setConversionService((ConversionService) conversionService);
            }
        }

        // 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

}
