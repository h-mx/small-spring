package com.mx.springframework.core.convert.support;

import com.mx.springframework.core.convert.converter.Converter;
import com.mx.springframework.core.convert.converter.ConverterFactory;
import com.mx.springframework.util.NumberUtils;
import org.jetbrains.annotations.Nullable;

/**
 * Converts from a String any JDK-standard Number implementation.
 * <p>
 * 从String转换为任何jdk标准的Number实现。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
