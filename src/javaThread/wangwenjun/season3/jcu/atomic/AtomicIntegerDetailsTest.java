package javaThread.wangwenjun.season3.jcu.atomic;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/8 0008 20:14
 * 主要方法：get set getAndAdd
 *
 */
public class AtomicIntegerDetailsTest {

    public static void main(String[] args) {


//        someMethod();

        threadTest();



    }

    private static void threadTest() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int v = atomicInteger.getAndAdd(1);
                    System.out.println(v);
                }
            }
        }.start();

        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int v = atomicInteger.getAndAdd(1);
                    System.out.println(v);
                }
            }
        }.start();
    }

    private static void someMethod() {
        AtomicInteger i = new AtomicInteger();

        System.out.println(i.get());

        i = new AtomicInteger(10);
        System.out.println(i.get());

        i.set(12);

        System.out.println(i.get());

        i.lazySet(15);
        System.out.println(i.get());

        int andSet = i.getAndAdd(10); //i取出来复制给andSet，然后给加10

        System.out.println(andSet);//15

        System.out.println(i.get());//25
    }

}
