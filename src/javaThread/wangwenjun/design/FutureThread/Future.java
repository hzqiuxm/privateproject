package javaThread.wangwenjun.design.FutureThread;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/30 0030 15:38
 */
public interface Future<T> {

    T get()  throws InterruptedException;
}
