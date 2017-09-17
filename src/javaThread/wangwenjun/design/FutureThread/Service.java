package javaThread.wangwenjun.design.FutureThread;

import java.util.function.Consumer;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/30 0030 15:42
 */
public class Service {

    //不需要等待的方式
    public <T> Future submit(final FutureTask<T> task, final Consumer<T> consumer){

        AsynFuture<T> asynFuture = new AsynFuture<>();

        new Thread(()->{
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();

        return asynFuture;
    }

    //需要等待的方式
    public <T> Future submit(final FutureTask<T> task){

        AsynFuture<T> asynFuture = new AsynFuture<>();

        new Thread(()->{
            T result = task.call();
            asynFuture.done(result);
        }).start();

        return asynFuture;
    }
}
