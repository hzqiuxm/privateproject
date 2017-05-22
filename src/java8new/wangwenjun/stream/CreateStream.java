package java8new.wangwenjun.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/22 0022 10:13
 */
public class CreateStream {

    public static void main(String[] args) {

//        CreateStreamFromCollection().forEach(System.out::println);
//        CreateStreamFromValues().forEach(System.out::println);
        CreateStreamFromIterater().forEach(System.out::println);
    }



    /**
     * 通过Collection来创建stream
     * @return
     */
    private static Stream<String> CreateStreamFromCollection(){

        List<String> list = Arrays.asList("hello", "hzqiuxm", "welcome to stram");

        return list.stream();
    }

    private static Stream<String> CreateStreamFromValues (){

        return Stream.of("hello", "hzqiuxm", "welcome to stream");

    }

    private static Stream<Integer> CreateStreamFromIterater(){

       return Stream.iterate(0, n -> n + 2).limit(10);


    }
}
