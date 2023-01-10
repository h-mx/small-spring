package com.mx.springframework.beans;

/**
 * bean属性
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/3
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
