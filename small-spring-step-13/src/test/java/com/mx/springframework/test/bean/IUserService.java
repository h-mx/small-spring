package com.mx.springframework.test.bean;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public interface IUserService {

    String queryUserInfo();

    String register(String userName);
}
