package javaThread.wangwenjun;

import java.util.LinkedList;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/6 0006 10:57
 */
public class Gate extends Thread {

    public static Object LOCK = new Object();

    public static LinkedList<String> LINKEDLIST = new LinkedList<>();


    @Override
    public void run() {

        synchronized (LOCK){

            while (true){

                if (LINKEDLIST.size()<=0){

                    try {
                        System.out.println("wait.................................");
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "---ok" + LINKEDLIST.get(0));
                LINKEDLIST.removeFirst();
                LOCK.notifyAll();

            }

        }
    }


}
