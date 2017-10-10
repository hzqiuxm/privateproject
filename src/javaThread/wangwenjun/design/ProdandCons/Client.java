package javaThread.wangwenjun.design.ProdandCons;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/20 0020 10:21
 */
public class Client {

    public static void main(String[] args) {

        final MessageQueue messageQueue= new MessageQueue();

        new Producer(messageQueue,1).start();

        new Customer(messageQueue,1).start();
    }
}
