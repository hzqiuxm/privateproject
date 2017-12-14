package java8new.wangwenjun.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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
//        CreateStreamFromIterater().forEach(System.out::println);

        CreateStreamFromOther1().forEach(System.out::println);
    }


    /**
     * 通过数组创建
     * @return
     */
    private static Stream<String> CreateStreamFromArrays(){

        String[] strings = {"a","b","c","d"};

        return Stream.of(strings);
    }

    /**
     * 通过Collection来创建stream
     * @return
     */
    private static Stream<String> CreateStreamFromCollection(){

        List<String> list = Arrays.asList("hello", "hzqiuxm", "welcome to stram");

        return list.stream();
    }

    /**
     * 使用Values创建
     * @return
     */
    private static Stream<String> CreateStreamFromValues (){

        return Stream.of("hello", "hzqiuxm", "welcome to stream");

    }

    /**
     * 使用迭代器创建
     * @return
     */
    private static Stream<Integer> CreateStreamFromIterater(){

       return Stream.iterate(0, n -> n + 2).limit(10);

    }


    /**
     * 通过Generate创建
     * @return
     */
    private static Stream<String> CreateStreamFromGenerate(){

        return Stream.generate(()-> "hello");

    }

    private static IntStream CreateStreamFromOther1(){

        String str = "qwertyuiop";

        return  str.chars();


    }


}
