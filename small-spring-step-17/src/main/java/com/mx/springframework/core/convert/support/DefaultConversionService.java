package com.mx.springframework.core.convert.support;

import com.mx.springframework.core.convert.converter.ConverterRegistry;

/**
 * A specialization of GenericConversionService configured by default with converters appropriate for most environments.
 * <p>
 * GenericConversionService的专门化，默认配置为适合大多数环境的转换器。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public class DefaultConversionService extends GenericConversionService {
    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
