package java8new.wangwenjun.AdvanceAction;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/1 0001 15:24
 */
public class SpliteratorAction {

    public static void main(String[] args) {


        IntStream intStream = IntStream.rangeClosed(0, 100);

        Spliterator.OfInt spliterator = intStream.spliterator();
        Consumer<Integer> consumer = i-> System.out.println(i);

        spliterator.forEachRemaining(consumer);
    }
}
