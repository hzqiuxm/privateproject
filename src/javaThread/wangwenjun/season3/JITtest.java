package javaThread.wangwenjun.season3;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/8 0008 20:00
 * JIT优化后，线程只从缓存中获取变量值不会从主存中获取
 * 导致init被修改成true后，线程仍然不会结束
 * 解决方法：加一个volatile修饰即可
 */
public class JITtest {

    private static boolean init = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                while (!init){

                }
            }
        }.start();


        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                init = true;
                System.out.println("Set init is true!");
            }
        }.start();
    }



}
