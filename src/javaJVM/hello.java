package javaJVM;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/30 0030 11:23
 */
public class hello {

    private static String msg = "hello hzqiuxm";

    public static void main(String[] args) {

        System.out.println(msg);
        hello h1 = new hello();

        System.out.println(h1.getClass().getClassLoader().getParent().getParent());
    }
}
