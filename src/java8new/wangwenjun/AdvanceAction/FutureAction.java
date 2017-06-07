package java8new.wangwenjun.AdvanceAction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/2 0002 15:27
 */
public class FutureAction {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "I am error";
            }
        });



        System.out.println(future.get());
        executorService.shutdown();
    }
}
