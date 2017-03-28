package javaThread.lesson1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/27 0027 19:02
 * 变量在线程内共享，自己用map实现,非ThreadLocal实现方式
 */


public class ThreadScopeShareData {

    private static int data = 0;
    private static Map mapThreadData = new HashMap();
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int data = new Random().nextInt();
                            System.out.println(Thread.currentThread().getName()
                                    + "has data : " + data );
                            mapThreadData.put(Thread.currentThread().getName(),data);
                            new A().get();
                            new B().get();
                        }
                    }
            ).start();
        }

    }

    static  class A{

        public void get(){

            System.out.println("A get data " + mapThreadData.get(Thread.currentThread().getName()));
        }

    }

    static  class B{

        public void get(){
            System.out.println("B get data " + mapThreadData.get(Thread.currentThread().getName()));
        }
    }


}
