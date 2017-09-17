package javaThread.wangwenjun.base.lock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/11 0011 15:24
 */
public class Main {

    public static void main(String[] args) {


        int a = 0;
        boolean flag = false;
        String  name = "hello";

        if(flag){

            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");
        }


        System.out.println("---------------------------");

        OUTER:while(a < 10){

            System.out.println("==================");
            a++;
            break OUTER;
        }

    }
}
