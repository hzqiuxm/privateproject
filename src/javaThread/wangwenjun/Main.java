package javaThread.wangwenjun;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/6 0006 11:14
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("-------------------------");

        Gate gate = new Gate();
        gate.start();
        Thread.sleep(100);
        for (int i = 0; i <5; i++) {
            synchronized (Gate.LOCK) {

                Gate.LINKEDLIST.addLast("string " + i);
                Gate.LOCK.notifyAll();
            }
        }

    }
}
