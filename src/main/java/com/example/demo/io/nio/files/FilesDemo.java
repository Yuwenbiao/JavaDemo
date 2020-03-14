package com.example.demo.io.nio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Files示例
 *
 * @author ywb
 * @date 2020/3/14 21:05
 */
public class FilesDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(getOwner());
    }

    /**
     * 获取文件所属人
     *
     * @throws IOException IO异常
     */
    public static String getOwner() throws IOException {
        Path path = Paths.get("D:\\projects\\java学习demo\\JavaDemo\\pom.xml");
        return Files.getOwner(path).getName();
    }
}
