package javaThread.lesson1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 10:29
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
 */
public class ThreadTest2 {

    private static int j = 0;
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {

            Inc inc = new Inc();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true){
                        inc.inc();
                        System.out.println("inc" + Thread.currentThread().getName() + "j = " + j);
                    }

                }
            }){

            }.start();
        }


        for (int i = 0; i < 2; i++) {

            Dec dec = new Dec();
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                dec.dec();
                                System.out.println("dec " + Thread.currentThread().getName() + "j = " + j);
                            }
                        }
                    }
            ){}.start();
        }


    }

    static class Inc{

        public synchronized void inc(){
            j++;
            System.out.println("inc " + Thread.currentThread().getName() + "j = " + j);
        }

    }

    static class Dec{

        public synchronized void dec(){
            j--;
            System.out.println("dec " + Thread.currentThread().getName() + "j = " + j);
        }

    }


};


