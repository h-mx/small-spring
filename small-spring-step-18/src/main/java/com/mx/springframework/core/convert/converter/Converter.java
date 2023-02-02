package com.mx.springframework.core.convert.converter;

/**
 * A converter converts a source object of type S to a target of type T.
 * <p>
 * 转换器将类型 S 的 source 对象转换为类型 T 的目标。
 * <p>
 * 类型转换处理接口
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public interface Converter<S, T> {
    /**
     * 将类型S的源对象转换为目标类型T。
     */
    T convert(S source);
}
