package com.example.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * JSON转换
 *
 * @author ywb
 * @date 2020/4/4 11:08
 */
public class JsonTranslation {
    public static void main(String[] args) {
        JSONObject jsonObject = string2Json();
        System.out.println(jsonObject.getString("name"));
    }

    /**
     * 字符串转JSON
     *
     * @return JSON对象
     */
    public static JSONObject string2Json() {
        String jsonStr = "{\"name\":\"Tome\"}";
        return JSON.parseObject(jsonStr);
    }
}
