package java8new.wangwenjun.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/22 0022 21:01
 */
public class StreamFilter {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> collect = list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);


        Integer integer1 = list.stream().filter(integer -> integer % 2 != 0).findAny().get();
        System.out.println(integer1);


        Integer reduce = list.stream().reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(reduce);
    }
}
