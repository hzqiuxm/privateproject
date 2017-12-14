package javaThread.wangwenjun.season3.jcu.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/11 0011 19:47
 */
public class AtomicBolleanTest {

    public static void main(String[] args) {

        someMethod();



    }

    private static void someMethod() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        System.out.println(atomicBoolean.get());

        boolean andSet = atomicBoolean.getAndSet(true);

        System.out.println("andSet = " + andSet);

        System.out.println("atomicBoolean = " +atomicBoolean.get());

        atomicBoolean.compareAndSet(true,false);

        System.out.println("atomicBoolean = " +atomicBoolean.get());
    }
}
