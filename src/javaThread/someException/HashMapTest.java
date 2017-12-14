package javaThread.someException;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/14 0014 9:44
 * 测试HashMap在多线程并发执行环境下的异常
 * 异常情况大致分为3种：
 * 1 正常结束，大小符合预期100000
 * 2 正常结束，结果小于100000
 * 3 死循环，JDK8以后不会出现了
 *  如果把HashMap换成ArrayList的话，不会出现死循环，但因为扩容过程可能被破坏，导致异常
 */
public class HashMapTest {


    static Map<String,String> map = new HashMap<>();


    public static class AddThread implements Runnable{

        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i+=2) {
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new AddThread(0));
        Thread t2 = new Thread(new AddThread(1));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(map.size());

    }
}
