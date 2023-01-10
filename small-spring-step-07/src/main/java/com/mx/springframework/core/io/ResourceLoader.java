package com.mx.springframework.core.io;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/6
 */
public interface ResourceLoader {
    /**
     * 从类路径加载的伪URL前缀: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
