package javaThread.wangwenjun.design.readWriteLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/29 0029 10:10
 */
public class Client {

    public static void main(String[] args) {

        final ShareData shareData = new ShareData(10);

        new ReadWorker(shareData).start();
        new ReadWorker(shareData).start();


        new WriteWorker(shareData, "qwertyuiopasdfg").start();
        new WriteWorker(shareData, "QWERTYUIOPASDFG").start();

    }
}
