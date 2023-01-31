package com.mx.springframework.test.bean;

import com.mx.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小胡，深圳，福田");
        hashMap.put("10002", "小刘，重庆，万州");
        hashMap.put("10003", "小陈，重庆，大渡口");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}