package javaJVM;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/7 0007 10:24
 * 局部变量和操作数栈示例
 */
public class Mytest3 {

    public int f1(int a,int b){
        int c = a + b;

        return a+b-c;
    }

    public static void main(String[] args) {

        Mytest3 t3 = new Mytest3();

        t3.f1(1,2);

    }
}
