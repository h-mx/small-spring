package com.mx.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小胡");
        hashMap.put("10002", "小刘");
        hashMap.put("10003", "小陈");
        hashMap.put("10004", "小王");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}