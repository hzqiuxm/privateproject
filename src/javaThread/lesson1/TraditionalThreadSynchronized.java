package javaThread.lesson1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/27 0027 14:36
 * 多线程问题举例
 */
public class TraditionalThreadSynchronized {

    public static void main(String[] args) {

        new TraditionalThreadSynchronized().init();

    }

    private void init(){
        final Outputer outputer = new Outputer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    outputer.output("hzqiuxm");

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    outputer.output("handanrujiaren");

                }
            }
        }).start();

    }


    public class Outputer{

        //synchronized加载方法前，实现同步就可以避免多线程问题,要注意synchronized对象一定要是同一个对象
        public  void output(String name){
            int len = name.length();

            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();

            /*synchronized (this){
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }*/
        }
    }
}
