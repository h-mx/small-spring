package com.mx.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.mx.springframework.beans.BeansException;
import com.mx.springframework.beans.PropertyValue;
import com.mx.springframework.beans.factory.config.BeanDefinition;
import com.mx.springframework.beans.factory.config.BeanReference;
import com.mx.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.mx.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.mx.springframework.core.io.Resource;
import com.mx.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用于XML Bean定义的Bean定义阅读器。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            this.loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        this.loadBeanDefinitions(getResourceLoader().getResource(location));
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            this.loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node beanNode = childNodes.item(i);
            // 判断属性
            if (!(beanNode instanceof Element)) continue;
            // 判断对象
            if (!"bean".equals(beanNode.getNodeName())) continue;
            // 解析标签 bean
            Element bean = (Element) beanNode;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //增加对init-method、destroy-method的读取
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");

            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            beanName = StrUtil.isNotEmpty(beanName) ? beanName : StrUtil.lowerFirst(clazz.getSimpleName());

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            //额外设置到beanDefinition中
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            // 读取属性并填充
            NodeList beanChildNodes = bean.getChildNodes();
            for (int j = 0; j < beanChildNodes.getLength(); j++) {
                Node propertyNode = beanChildNodes.item(j);
                if (!(propertyNode instanceof Element)) continue;
                if (!"property".equals(propertyNode.getNodeName())) continue;
                // 解析标签 property
                Element property = (Element) propertyNode;
                String propertyName = property.getAttribute("name");
                String propertyValue = property.getAttribute("value");
                String propertyRef = property.getAttribute("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(propertyRef) ? new BeanReference(propertyRef) : propertyValue;
                // 创建属性信息
                PropertyValue pv = new PropertyValue(propertyName, value);
                beanDefinition.getPropertyValues().addPropertyValue(pv);
            }

            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
