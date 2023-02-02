package com.mx.springframework.core.convert.converter;

/**
 * For registering converters with a type conversion system.
 * <p>
 * 用于向类型转换系统注册转换器。
 * <p>
 * 类型转换注册接口
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public interface ConverterRegistry {

    /**
     * Add a generic converter to this registry.
     * <p>
     * 向注册中心添加通用转换器。
     */
    void addConverter(GenericConverter genericConverter);

    /**
     * Add a plain converter to this registry.
     * The convertible source/target type pair is derived from the Converter's parameterized types.
     * <p>
     * 向注册中心添加普通转换器。
     * 可转换源/目标类型对派生自转换器的参数化类型。
     *
     * @throws IllegalArgumentException 如果参数化类型无法解析
     */
    void addConverter(Converter<?, ?> converter);

    /**
     * Add a ranged converter factory to this registry.
     * The convertible source/target type pair is derived from the ConverterFactory's parameterized types.
     * <p>
     * 向此注册表添加远程转换器工厂。
     * 可转换源/目标类型对派生自ConverterFactory的参数化类型。
     *
     * @throws IllegalArgumentException 如果参数化类型无法解析
     */
    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

}
