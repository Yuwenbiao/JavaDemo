package com.example.demo.string;

import java.util.Stack;

/**
 * 将字符串反转
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/2/5 15:46
 */
public class StringReverse {
    private static final String STR = "abc";

    /**
     * 通过StringBuffer
     */
    private void reverseByStringBuffer() {
        String reverse = new StringBuffer(STR).reverse().toString();
    }

    /**
     * 算法1
     */
    public static String reverse1(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse1(right) + reverse1(left);
    }

    /**
     * 算法2
     */
    public static String reverse2(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    /**
     * 算法3
     */
    public static String reverse3(String s) {
        char[] array = s.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i];
        }

        return reverse;
    }

    /**
     * 算法5
     */
    public static String reverse5(String orig) {
        char[] s = orig.toCharArray();
        int n = s.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = s[i];
            s[i] = s[n - i];
            s[n - i] = temp;
        }
        return new String(s);
    }

    /**
     * 算法6
     */
    public static String reverse6(String s) {
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }

    /**
     * 算法7
     */
    public static String reverse7(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
        }

        String reversed = "";
        for (int i = 0; i < str.length; i++) {
            reversed += stack.pop();
        }
        return reversed;
    }
}
