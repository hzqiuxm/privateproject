package javaThread.wangwenjun;

import x_gen.genconf.implmentors.ThemeImplmentor;

import java.util.Optional;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/22 0022 16:24
 */
public class VolatileTest {

    private static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {

        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue<MAX_LIMIT){
                if(localValue!=INIT_VALUE){
                    Optional.of("T1-->" + INIT_VALUE).ifPresent(System.out::println);
                    localValue = INIT_VALUE;
                }

            }
        },"T1").start();


        new Thread(()->{
            int localValue = INIT_VALUE;
            while (INIT_VALUE<MAX_LIMIT){
                Optional.of("T2-->" + (++localValue)).ifPresent(System.out::println);
                INIT_VALUE = localValue;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T2").start();

    }
}
