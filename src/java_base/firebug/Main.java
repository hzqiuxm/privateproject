package java_base.firebug;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/9 0009 21:20
 */
public class Main {

    public static void main(String[] args) {
        U1 u1 = new U1(128l,"qiuxm");

        U2 u2 = new U2(128l,"qiuxm");

        if(u1.getId() == u2.getId()){
            System.out.println("== 了");
        }

        if(u1.getStr() == u2.getStr()){
            System.out.println("也 == 了");
        }


    }
}
