package com.mx.springframework.core.convert.converter;

import cn.hutool.core.lang.Assert;

import java.util.Set;

/**
 * Generic converter interface for converting between two or more types.
 * <p>
 * 用于在两个或多个类型之间进行转换的通用转换器接口。
 * <p>
 * 通用的转换接口
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/2/1
 */
public interface GenericConverter {

    /**
     * 返回此转换器可以在其中进行转换的source类型和target类型。
     */
    Set<ConvertiblePair> getConvertibleTypes();

    /**
     * 将源对象转换为类型描述符描述的targetType。
     *
     * @param source     要转换的源对象(可以是null)
     * @param sourceType 要转换的字段的类型描述符
     * @param targetType 要转换到的字段的类型描述符
     * @return 转换后的对象
     */
    Object convert(Object source, Class<?> sourceType, Class<?> targetType);

    /**
     * Holder for a source-to-target class pair.
     */
    final class ConvertiblePair {
        private final Class<?> sourceType;

        private final Class<?> targetType;

        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            Assert.notNull(sourceType, "Source type must not be null");
            Assert.notNull(targetType, "Target type must not be null");
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return this.sourceType;
        }

        public Class<?> getTargetType() {
            return this.targetType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ConvertiblePair.class) {
                return false;
            }
            ConvertiblePair other = (ConvertiblePair) obj;
            return this.sourceType.equals(other.sourceType) && this.targetType.equals(other.targetType);

        }

        @Override
        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }
    }

}
