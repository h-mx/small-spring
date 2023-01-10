package com.mx.springframework.beans;

/**
 * bean异常
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
