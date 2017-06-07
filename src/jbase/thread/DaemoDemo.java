package jbase.thread;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/7 0007 11:24
 */
public class DaemoDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            while (true){
                System.out.println("Orz");
            }
        });

//        thread.setDaemon(true);
        thread.start();
    }
}
