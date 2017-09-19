package javaThread.wangwenjun.design.balkingData;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/19 0019 14:44
 */
public class BalkingClient {

    public static void main(String[] args) {


        BalkingData balkingData = new BalkingData("D:\\data\\1.txt","=====begin");

        new CustomerThread(balkingData).start();

        new WaitService(balkingData).start();
    }
}
