package java8new.java8InAction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/10/4 0004 22:36
 */
public class FilesandPath {

    public static void main(String[] args) {

        Path path = Paths.get("D:\\data\\3.txt");
        try {
            List<String> contexts = Files.readAllLines(path);
            contexts.stream()
                    .filter(s->s.length()<15)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
