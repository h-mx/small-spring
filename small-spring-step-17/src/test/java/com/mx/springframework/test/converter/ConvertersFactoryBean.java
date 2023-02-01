package com.mx.springframework.test.converter;


import com.mx.springframework.beans.factory.FactoryBean;

import java.util.HashSet;
import java.util.Set;

public class ConvertersFactoryBean implements FactoryBean<Set<?>> {

    @Override
    public Set<?> getObject() throws Exception {
        HashSet<Object> converters = new HashSet<>();
        converters.add(new StringToLocalDateConverter("yyyy-MM-dd"));
        converters.add(new StringToIntegerConverter());
        return converters;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
