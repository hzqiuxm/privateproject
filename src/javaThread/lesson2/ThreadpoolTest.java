package javaThread.lesson2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 14:39
 * 线程池
 */
public class ThreadpoolTest {

    public static void main(String[] args) {

        ExecutorService threadPool1 = Executors.newCachedThreadPool();//带有缓存的线程池，根据任务自行增加线程数
        ExecutorService threadPool2 = Executors.newSingleThreadScheduledExecutor();//单个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(3);//固定线程数目线程池
        for ( int i =0;i < 10 ; i++) {
            final int taskId = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("ThreadName : " + Thread.currentThread().getName() +
                                " loop " + j + "for Task " + taskId);
                    }

                }
            });
        }

        System.out.println("----------------all task commit!----------------");
        threadPool.shutdown();


    }


}
