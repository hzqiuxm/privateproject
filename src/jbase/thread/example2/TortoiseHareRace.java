package jbase.thread.example2;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/7 0007 9:39
 * 龟兔赛跑游戏 为了程序执行速度用10ms代替1s
 */
public class TortoiseHareRace {

    public static void main(String[] args) throws InterruptedException {

        int totalStep = 100;

        //兔子线程
        new Thread(()->{

            int step = 0;
            boolean[] flags = {true,false};

            while (step<totalStep){
                boolean isSleep = flags[(int) ((Math.random()*10)%2)];
                if (isSleep){
                    System.out.println("兔子睡着了zzzz....");
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    step += 2;
                    System.out.println("兔子跑了： " + step + "步...");
                }
            }
        }).start();

        //乌龟线程
        new Thread(()->{

            int step = 0;
            while (step<totalStep){
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                step++;
                System.out.println("乌龟跑了： " + step + "步...");
            }

        }).start();


//        Thread.currentThread().join();


    }
}
