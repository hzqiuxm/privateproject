package javaThread.lesson2;

import java.util.concurrent.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 15:45
 * Callable Future 应用场景不大，了解即可
 */
public class CallableAndFutureTest {
    public static void main(String[] args) throws Exception {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


        Future<String> future = singleThreadExecutor.submit(
                new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(200);
                return "hello";
            }
        });

        System.out.println("等待接收结果---------------------");
        System.out.println("OK " + future.get());
    }
}


