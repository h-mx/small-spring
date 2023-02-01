package com.mx.springframework.context.support;

import com.mx.springframework.beans.factory.FactoryBean;
import com.mx.springframework.beans.factory.InitializingBean;
import com.mx.springframework.core.convert.ConversionService;
import com.mx.springframework.core.convert.converter.Converter;
import com.mx.springframework.core.convert.converter.ConverterFactory;
import com.mx.springframework.core.convert.converter.ConverterRegistry;
import com.mx.springframework.core.convert.converter.GenericConverter;
import com.mx.springframework.core.convert.support.DefaultConversionService;
import com.mx.springframework.core.convert.support.GenericConversionService;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * A factory providing convenient access to a ConversionService configured with converters appropriate for most environments.
 * Set the setConverters "converters" property to supplement the default converters.
 * <p>
 * 提供对配置了适合大多数环境的转换器的ConversionService的方便访问的工厂。设置setConverters "converters"属性以补充默认转换器。
 * <p>
 * 提供创建 ConversionService 工厂
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    @Nullable
    private Set<?> converters;

    @Nullable
    private GenericConversionService conversionService;


    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);

    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
