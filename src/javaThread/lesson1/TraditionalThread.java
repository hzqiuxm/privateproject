package javaThread.lesson1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/27 0027 13:33
 * 多线程基础回顾
 */
public class TraditionalThread {

    public static void main(String[] args)  throws Exception{

        //第一种方式继承Thread类，重写run方法
        Thread thread = new Thread(){
            @Override
            public void run() {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = 0;
                while (i<100000){
                    System.out.println(Thread.currentThread().getName());
                    i++;
//                    System.out.println(this.getName());
                }
            }
        };
        thread.start();


        //第二种方法，传入一个Runable对象
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<100000){
                    System.out.println(Thread.currentThread().getName());
                    i++;
                }
            }
        });

        thread2.start();



        //两种写法都用的时候,子类覆盖了父类的run方法，父类的run已经失效，runnable逻辑不可能有效了
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<100000){
                    System.out.println("Runnable : " + Thread.currentThread().getName());
                    i++;
                }
            }
        }){
            @Override
            public void run() {
                int i = 0;
                while (i<100000){
                    System.out.println("thread : " + Thread.currentThread().getName());
                    i++;
                }
            }
        }.start();

    }


}
