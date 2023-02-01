package com.mx.springframework.util;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link com.mx.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * <p>
 * 用于解析字符串值的简单策略接口。由 {@link com.mx.springframework.beans.factory.config.ConfigurableBeanFactory} 使用。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/31
 */
public interface StringValueResolver {
    String resolveStringValue(String strVal);
}
