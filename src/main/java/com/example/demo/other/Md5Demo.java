package com.example.demo.other;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * md5生成示例
 *
 * @author ywb
 * @date 2020/2/7 20:01
 */
public class Md5Demo {
    /**
     * 实现方式1
     */
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

    /**
     * 实现方式2
     * 利用Java自带的MessageDigest类实现的最简单的MD5加密方法
     */
    private static String md2(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 盐，用于混交md5
     */
    private static final String SLAT = "&%5123***&&%%$$#@";

    /**
     * 实现方式3
     * 原生
     */
    private static String md3(String dataStr) {
        try {
            dataStr = dataStr + SLAT;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (byte b : s) {
                result.append(Integer.toHexString((0x000000FF & b) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 实现方式4
     * 使用Spring中的工具类
     */
    public static String md4(String str) {
        String base = str + SLAT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
