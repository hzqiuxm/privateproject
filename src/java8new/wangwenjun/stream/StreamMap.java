package java8new.wangwenjun.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/22 0022 21:11
 */
public class StreamMap {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> collect = list.stream().map(integer -> integer * 2).collect(Collectors.toList());
        System.out.println(collect);


        String[] words = {"Hello bananer"};

        Arrays.stream(words)
                .map(w->w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

    }
}
