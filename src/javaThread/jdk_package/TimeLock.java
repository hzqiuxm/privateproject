package javaThread.jdk_package;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/3/12 16:51
 */
public class TimeLock implements Runnable{


    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)) {

                System.out.println("get lock success!" + Thread.currentThread().getName());

                Thread.sleep(6000);
            }else{

                System.out.println("get lock failed ......" + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

            if(lock.isHeldByCurrentThread()){

                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {

        TimeLock timeLock = new TimeLock();

        Thread t1 = new Thread(timeLock);
        Thread t2 = new Thread(timeLock);

        t1.start();
        t2.start();

    }
}
