package jbase.thread.example1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 20:47
 * A执行5次，轮到B执行10次，再轮到C执行15次，如此循环50次
 */
public class SingalTest {

    public static void main(String[] args) {

        new SingalTest().init();

    }

    public void init(){

        final Busniess busniess = new Busniess();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {

                    busniess.A();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 50; i++) {

                    busniess.B();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 50; i++) {
                    busniess.C();
                }
            }
        }).start();

    }


    private class Busniess{

        int status = 1;//1-A 2-B 3-C
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        public void A(){
            lock.lock();

            while (status!=1) {

                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                for (int i = 0; i < 5; i++) {
                    System.out.println(" A is running ......" + i);
                }

                status = 2;
                conditionB.signal();

                lock.unlock();


        }

        public void B(){

            lock.lock();

            while (status!=2) {
                try {
                    conditionB.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                for (int i = 0; i < 10; i++) {
                    System.out.println(" B is running ......" + i);
                }

                status = 3;
                conditionC.signal();

                lock.unlock();

        }

        public void C(){

            lock.lock();

            while (status!=3) {
                try {
                    conditionC.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                for (int i = 0; i < 15; i++) {
                    System.out.println(" C is running ......" + i);
                }
                status = 1;
                conditionA.signal();

                lock.unlock();

        }
    }

}
