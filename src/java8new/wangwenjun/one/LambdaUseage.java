package java8new.wangwenjun.one;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/17 0017 10:10
 */
public class LambdaUseage {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("green",120), new Apple("red",150));


        list.stream()
                .filter(apple -> apple.getColor().equals("green"))
                .collect(Collectors.toList())
                .forEach(out::println);

        System.out.println("-------------------");

       /* Consumer<String> consumer = s -> System.out.println(s);
        useConsumer(consumer,"Hello hzqiuxm!");*/

        useConsumer(System.out::println,"hello man");


        System.out.println("------------------------");

        //普通函数推导
        BiFunction<String,Integer,Character> f = String::charAt;

        System.out.println(f.apply("hzqiuxm",2));

        //构造函数推导
        BiFunction<String,Long,Apple> appleBiFunction = Apple::new;
        Apple apple = appleBiFunction.apply("red", 100L);
        System.out.println(apple);


        //自定义多个参数的Funcation
        ThreeFuncation<String,Long,String,ComplexApple> caf = ComplexApple::new;

        ComplexApple complexApple = caf.apply("green", 200L, "hfushi");
        System.out.println(complexApple);

    }

    private static <T> void useConsumer(Consumer<T> consumer,T t){

        consumer.accept(t);
        System.out.println("heihei");
        consumer.accept(t);
    }

}
