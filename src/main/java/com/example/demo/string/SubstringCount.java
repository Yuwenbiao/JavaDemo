package com.example.demo.string;

/**
 * 统计指定字符串"葡萄"出现的次数
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/2/5 20:38
 */
public class SubstringCount {
    String str = "吃葡萄不吐葡萄皮，不吃葡萄倒吐葡萄皮";

    /**
     * 第一种方式
     * 将字符串替换为空格，再转换成字符数组，统计空字符的数量
     */
    private void getCount1() {
        String str1 = str.replace("葡萄", " ");
        char[] data = str1.toCharArray();
        int count = 0;
        for (char a : data) {
            if (a == ' ') {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 第二种方式
     * 定位待匹配字符串位置，如果存在则进行计数并替换为空格，再对替换后的字符进行该操作，循环往复，直到字符串中不存在待匹配字符串
     */
    private void getCount2() {
        int count = 0;
        int x = 0;
        while (x != -1) {
            x = str.indexOf("葡萄");
            if (x != -1) {
                count++;
                str = str.replaceFirst("葡萄", "");
            }
        }
        System.out.println(count);
    }

    /**
     * 第三种方式
     * 循环检查字符串是否包含待匹配字符串并替换为空格，直到该字符串不存在，输出循环次数即字符串的数量
     */
    private void getCount3() {
        for (int x = 0; x < str.length(); x++) {
            if (str.contains("葡萄")) {
                str = str.replaceFirst("葡萄", "");
            } else {
                System.out.println(x);
                break;
            }
        }
    }

    /**
     * 第四种方式
     * 以待匹配字符串为分割符将字符串分割为数组，统计字符串数组长度，即字符串数量
     */
    private void getCount4() {
        String[] data = str.split("葡萄");
        if (!str.endsWith("葡萄")) {
            //这里startsWith("葡萄")在split时，会在开头产生空串
            System.out.println(data.length - 1);
        } else {
            System.out.println(data.length);
        }
    }

    /**
     * 第五种方式
     * 循环定位待匹配字符串位置，并从该位置截取后面的字符串，直到待匹配字符串不存在，输出统计的次数
     */
    private void getCount5() {
        int count = 0;
        int x = 0;
        while (x != -1) {
            x = str.indexOf("葡萄");
            if (x != -1) {
                if ((x + 2) < str.length()) {
                    str = str.substring(x + 2);
                }
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 第六种方式
     * 将待匹配字符串替换为空，并用源字符串长度减去替换后的字符串长度，得到的长度除以待匹配字符串长度即数量
     */
    private void count6() {
        String str2 = str.replace("葡萄", "");
        System.out.println((str.length() - str2.length()) / 2);
    }
}
