package com.example.demo.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 反转map示例
 *
 * @author ywb
 * @date 2020/3/4 19:07
 */
public class BiMapDemo {
    public static void main(String[] args) {
        biMapDemo();
    }

    private static void biMapDemo() {
        BiMap<String, String> britishToAmerican = HashBiMap.create();
        // Initialise and use just like a normal map
        britishToAmerican.put("aubergine", "eggplant");
        System.out.println(britishToAmerican.get("aubergine"));

        BiMap<String, String> americanToBritish = britishToAmerican.inverse();
        System.out.println(americanToBritish.get("eggplant"));

        //强制插入value非位移的值
        britishToAmerican.forcePut("forcePut", "eggplant");
        System.out.println(britishToAmerican.get("forcePut"));
    }
}
