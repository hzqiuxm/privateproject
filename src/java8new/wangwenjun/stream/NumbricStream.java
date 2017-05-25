package java8new.wangwenjun.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/23 0023 9:42
 */
public class NumbricStream {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8});

        System.out.println(stream.filter(integer -> integer > 3)
                .reduce(0, Integer::sum).intValue());

    }
}
