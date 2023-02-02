package com.mx.springframework.stereotype;

import java.lang.annotation.*;

/**
 * Indicates that an annotated class is a "component".
 * Such classes are considered as candidates for auto-detection
 * when using annotation-based configuration and classpath scanning.
 * <p>
 * 指示带注释的类是“组件”。在使用基于注释的配置和类路径扫描时，这些类被认为是自动检测的候选类。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
