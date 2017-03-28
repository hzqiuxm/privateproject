package javaThread.lesson1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/27 0027 16:24
 * 子线程先10次，主线程后100次，如此反复50次
 */
public class ThreadTest1 {

    public static void main(String[] args) {

        new ThreadTest1().init();

    }

    public void init(){

        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.subThread(i);
                }

            }
        }).start();

        for (int i = 1; i <=50 ; i++) {
            business.mainThread(i);
        }

    }

    //把循环的任务抽象成一个业务类
    class Business{

        private boolean isSub = true;

        public synchronized void mainThread(int i){

            while(isSub)//不要用if，遇到假唤醒也没问题
                try {

                    this.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequece of " + j + " loop of " + i);
                }

                isSub = true;
                this.notify();

        }

        public synchronized void subThread(int i){

            while(!isSub)//不要用if，遇到假唤醒也没问题
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequece of " + j + " loop of " + i);
                }

                isSub = false;
                this.notify();

        }


    }
}
