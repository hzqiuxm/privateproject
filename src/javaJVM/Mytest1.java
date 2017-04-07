package javaJVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/5 0005 15:19
 * 模拟堆内存溢出
 */
public class Mytest1 {
    private byte[] bs = new byte[1024*1024];//1m


    public static void main(String[] args) {
        List list = new ArrayList<>();

        int num = 0;

        try {
            while(true){
                num ++;
                list.add(new Mytest1());
            }
        } catch (Throwable e) {
            System.out.println("num = " +num); //jvm设置 -Xmx10m
            e.printStackTrace();

        }

        //查看设置的VM参数启动后变化

//        System.out.println("max === " + Runtime.getRuntime().maxMemory()/1024/1024);
//        System.out.println("free === " + Runtime.getRuntime().freeMemory()/1024/1024);
//        System.out.println("total === " + Runtime.getRuntime().totalMemory()/1024/1024);

    }
}
