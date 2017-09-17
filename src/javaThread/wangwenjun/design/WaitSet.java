package javaThread.wangwenjun.design;

import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/21 0021 11:02
 */
public class WaitSet {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        IntStream.rangeClosed(1,10)
                .forEach(i ->
                new Thread(String.valueOf(i)){
                    @Override
                    public void run() {

                        synchronized (LOCK){
                            try {
                                System.out.println(Thread.currentThread().getName() + " will come to wait set!");
                                LOCK.wait();
                                System.out.println(Thread.currentThread().getName() + " is back from wait set!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start());


        IntStream.rangeClosed(1,10)
                .forEach(i->{
                    synchronized (LOCK){
                        LOCK.notify();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
