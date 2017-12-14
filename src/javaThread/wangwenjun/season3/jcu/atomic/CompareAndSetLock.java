package javaThread.wangwenjun.season3.jcu.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/11 0011 15:44
 */
public class CompareAndSetLock {

    private final AtomicInteger value = new AtomicInteger(0);

    private Thread lockThread;

    /**
     * 尝试获得锁，获得不到抛出异常，获得成功，将锁标记置为1
     * @throws GetLockExpection
     */
    public void tryLock() throws GetLockExpection{

        boolean b = value.compareAndSet(0, 1);

        if(!b){
            throw new GetLockExpection("Get the Lock failed");
        }else {

            lockThread = Thread.currentThread();
        }

    }

    /**
     * 释放锁，如果已经释放直接返回
     * 只有获取锁的线程，才能释放锁，释放时对期望值是1的设置成0
     */
    public void unLock(){

        if(0 == value.get()){
            return;
        }

        if(lockThread == Thread.currentThread()){
            value.compareAndSet(1, 0);
        }



    }
}
