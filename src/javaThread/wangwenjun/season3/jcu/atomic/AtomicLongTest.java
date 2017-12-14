package javaThread.wangwenjun.season3.jcu.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/12 0012 16:27
 */
public class AtomicLongTest {

    public static void main(String[] args) {

        LongBinaryOperator longBinaryOperator = (a,b)->{

            return a>b?a:b;
        };

        AtomicLong atomicLong = new AtomicLong(9L);
        long accumulateAndGet = atomicLong.accumulateAndGet(10L, longBinaryOperator);

        System.out.println(accumulateAndGet);



        AtomicLong atomicLong2 = new AtomicLong(9L);
        long andAccumulate = atomicLong2.getAndAccumulate(10L, longBinaryOperator);

        System.out.println(andAccumulate);

    }
}
