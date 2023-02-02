package com.mx.springframework.core.convert.converter;

/**
 * A factory for "ranged" converters that can convert objects from S to subtypes of R.
 * <p>
 * 一个用于 “ranged” 转换器的工厂，可以将对象从 S 转换为 R 的子类型
 * <p>
 * 类型转换工厂
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public interface ConverterFactory<S, R> {

    /**
     * Get the converter to convert from S to target type T, where T is also an instance of R.
     * <p>
     * 获取一个从S转换到目标类型T的转换器，其中T也是R的一个实例。
     *
     * @param <T>        目标类型
     * @param targetType 要转换为的目标类型
     * @return 从S到T的转换器
     */
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
