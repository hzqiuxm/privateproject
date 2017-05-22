package java8new.wangwenjun.one;

import java.nio.file.DirectoryStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/16 0016 10:23
 */
public class LambdaExpression {

    public static void main(String[] args) {

        Comparator<Apple> bycolor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };


        List<Apple> list = Collections.emptyList();

        list.sort(bycolor);


        //lambda expression
        Comparator<Apple> bycolor2 = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
        list.sort(bycolor2);



        Function<String, Integer> stringConsumer = (String s) -> s.length();

        Predicate<Apple> preApple = (Apple a) -> a.getColor().equals("green");

        IntSupplier doubleSupplier = () -> 43;
        System.out.println(doubleSupplier);



    }
}
