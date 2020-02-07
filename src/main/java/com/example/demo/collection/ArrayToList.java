package com.example.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组和List互相转换
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/2/7 11:54
 */
public class ArrayToList {
    private String[] arr = new String[]{"1", "2", "3"};

    /**
     * 数组转List方式1
     */
    private void array2List1() {
        // 待转换成的list
        List<String> list = new ArrayList<>();
        // 通过Collections转换
        Collections.addAll(list, arr);
    }

    /**
     * 数组转List方式2
     * Arrays.asList()返回一个受指定数组支持的固定大小的列表。所以不能做Add、Remove等操作。
     * 如果想对转换后的list再进行add等操作，可以通过list构造函数转换成可操作的list(add等)：
     * List<String> list = new ArrayList<String>(Arrays.asList(arr));
     */
    private void array2List2() {
        // 通过Arrays转换成list
        List<String> list = Arrays.asList(arr);
    }

    /**
     * List转数组
     */
    private void list2Array() {
        List<String> list = Arrays.asList("1", "2", "3");
        // 通过toArray转换为Object数组
        Object[] objArray = list.toArray();

        //通过toArray转换为String数组
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
    }
}
