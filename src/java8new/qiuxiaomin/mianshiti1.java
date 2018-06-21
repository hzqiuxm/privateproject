package java8new.qiuxiaomin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/6/12 20:24
 * 请使用Lamda表达式写出下面的程序：将下面list中的值根据”|”分割，获取分割结果中长度大于3的第一个值，如果存在该值就输出。
 */
public class mianshiti1 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("c|c++","java", "js|python|php|ruby");

        stringList.stream()
                .flatMap(e-> Stream.of(e.split("\\|")))
                .filter(e->e.length()>3)
                .findFirst()
                .ifPresent(System.out::print);
    }
}
