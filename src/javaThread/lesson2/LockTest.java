package javaThread.lesson2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 18:40
 */
public class LockTest {
    public static void main(String[] args) {

        new LockTest().init();

    }

    private void init(){
        final Outputer outputer = new Outputer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    outputer.output("linjiangxian");

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    outputer.output("ziniuxiaozhu");

                }
            }
        }).start();

    }


    public class Outputer{

        //Lock实现
        Lock lock = new ReentrantLock();

        public   void output(String name){
            int len = name.length();

            lock.lock();

            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }



        }
    }
}
