package com.mx.springframework.beans.factory.support;

import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.factory.DisposableBean;
import com.mx.springframework.beans.factory.ObjectFactory;
import com.mx.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SingletonBeanRegistry的默认实现
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 空单例对象的内部标记:用作并发映射(不支持空值)的标记值。
     */
    protected static final Object NULL_OBJECT = new Object();

    /**
     * 一级缓存，普通对象
     * <p>
     * 单例对象的缓存: bean名称 --> bean实例
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 二级缓存，提前暴漏对象，没有完全实例化的对象
     * <p>
     * 早期单例对象的缓存: bean名称 --> bean实例
     */
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();

    /**
     * 三级缓存，存放代理对象
     * <p>
     * 独立工厂缓存: bean名称 --> ObjectFactory
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    /**
     * 销毁之前需要调用钩子方法的 bean
     */
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = earlySingletonObjects.get(beanName);
            // 判断二级缓存中是否有对象，这个对象就是代理对象，因为只有代理对象才会放到三级缓存中
            if (singletonObject == null) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        String[] disposableBeanNames = keySet.toArray(new String[0]);

        for (int i = 0; i < disposableBeanNames.length; i++) {
            String beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
