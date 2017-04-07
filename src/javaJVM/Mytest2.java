package javaJVM;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/5 0005 20:49
 * 栈溢出试验,JDK8要求最低160K
 */
public class Mytest2 {

    private int num = 0;
    public int callMe(int a,int b){
        num ++;
        return callMe(a,b);
    }

    public static void main(String[] args) {

        Mytest2 mytest2 = new Mytest2();

        mytest2.callMe(1,2);
    }
}
