package javaThread.wangwenjun.season3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/8 0008 15:02
 * 使用Volatile只能保证有序性和可见性，不能保证原子性，下面这个程序最后的结果value的值会少于10000
 * 如果使用原子类型，就不会
 */
public class volatileQuestion {

    private static volatile int value = 0;

    private static Set<Integer> setValue = Collections.synchronizedSet(new HashSet<>());


    public static void main(String[] args) throws InterruptedException {

//        testvolatile();

          testAtomi();


    }

    private static void testvolatile() throws InterruptedException {
        Thread t1 = new Thread(){

            @Override
            public void run() {
                int x = 0;

                while (x < 5000){
                    setValue.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tmp );
                    value += 1;
                    /**
                     * value = value + 1
                     * （1）get value from main memory to local memory
                     * (2) add 1 to x
                     * (3) assign the value to x
                     * (4) flush to main memory
                     */
                    x++;
                }
            }
        };


        Thread t2 = new Thread(){

            @Override
            public void run() {
                int x = 0;

                while (x < 5000){
                    setValue.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tmp );
                    value += 1;
                    x++;
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(setValue.size());
    }


    private static void testAtomi() throws InterruptedException{

        final AtomicInteger value = new AtomicInteger();

        Thread t1 = new Thread(){

            @Override
            public void run() {

                int x = 0;
                while (x <5000){
                    setValue.add(x);
                    int tmp = value.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + ":" + tmp );
                    x++;
                }
            }
        };

        Thread t2 = new Thread(){

            @Override
            public void run() {

                int x = 0;
                while (x <5000){
                    setValue.add(x);
                    int tmp = value.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + ":" + tmp );
                    x++;
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(setValue.size());

    }




}
