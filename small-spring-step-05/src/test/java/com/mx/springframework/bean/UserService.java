package com.mx.springframework.bean;

/**
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2022/12/30
 */
public class UserService {
    private String userId;

    private UserDao userDao;

    public String queryUserInfo() {
        return "查询用户信息：" + userDao.queryUserName(userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService{" +
               "uId='" + userId + '\'' +
               ", userDao=" + userDao +
               '}';
    }
}
