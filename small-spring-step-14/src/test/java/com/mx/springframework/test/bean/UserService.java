package com.mx.springframework.test.bean;

import com.mx.springframework.beans.factory.annotation.Autowired;
import com.mx.springframework.beans.factory.annotation.Value;
import com.mx.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
@Component("userService")
public class UserService implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName("10001") + "，" + token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
