package javaThread.someException;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/14 0014 10:08
 * 线程中断测试，该线程不会被中断，如果要实现中断，那必须自己实现中断的操作,类似线程2的操作
 * 中断方法：
 * interrupt() 发起中断线程操作，修改中断标志位状态
 * isInterrupt() 状态位是否出于中断状态
 * interrupted() 判断线程中断状态，并清楚中断标志位
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(){

            @Override
            public void run() {
                while (true){
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(10000);
        t1.interrupt();


        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        break;
                    }
                }
            }
        };

    }
}
