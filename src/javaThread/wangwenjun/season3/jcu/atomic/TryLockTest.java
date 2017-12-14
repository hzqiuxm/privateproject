package javaThread.wangwenjun.season3.jcu.atomic;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/11 0011 15:33
 */
public class TryLockTest {

    private final static CompareAndSetLock lock = new CompareAndSetLock();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        doSomething();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (GetLockExpection getLockExpection) {
                        getLockExpection.printStackTrace();
                    }
                }
            }.start();
        }

    }

    private static void doSomething() throws InterruptedException, GetLockExpection {

        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName()+ "get the lock");
            Thread.sleep(300000L);
        }finally {
            lock.unLock();
        }
    }
}
