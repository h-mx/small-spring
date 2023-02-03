package com.mx.springframework.aop.support;


import com.mx.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

public abstract class StaticMethodMatcher implements MethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> clazz) {
        throw new UnsupportedOperationException("Illegal MethodMatcher usage");
    }
}
