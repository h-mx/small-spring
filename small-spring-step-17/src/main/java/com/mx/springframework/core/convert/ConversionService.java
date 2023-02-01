package com.mx.springframework.core.convert;


import org.jetbrains.annotations.Nullable;

/**
 * A service interface for type conversion. This is the entry point into the convert system.
 * Call {@link #convert(Object, Class)} to perform a thread-safe type conversion using this system.
 * <p>
 * 用于类型转换的服务接口。这是进入转换系统的入口点。
 * 调用 {@link #convert(Object, Class)} 使用此系统执行线程安全的类型转换。
 * <p>
 * 类型转换抽象接口。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public interface ConversionService {

    /**
     * 如果 sourceType 的对象可以转换为 targetType，则返回true。
     */
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    /**
     * 将给定的 source 转换为指定的 targetType。
     */
    <T> T convert(Object source, Class<T> targetType);
}
