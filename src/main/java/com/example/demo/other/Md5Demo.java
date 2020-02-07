package com.example.demo.other;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * md5生成示例
 *
 * @author ywb
 * @date 2020/2/7 20:01
 */
public class Md5Demo {
    public static void main(String[] args) {
        System.out.println(md5("abc"));
    }

    private static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes(StandardCharsets.UTF_8));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {
        final char[] hexDigits = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (byte aByte : bytes) {
            ret.append(hexDigits[(aByte >> 4) & 0x0f]);
            ret.append(hexDigits[aByte & 0x0f]);
        }
        return ret.toString();
    }
}
