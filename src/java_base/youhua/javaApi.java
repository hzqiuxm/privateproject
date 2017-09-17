package java_base.youhua;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/7/6 0006 17:29
 */
public class javaApi {


    public static void main(String[] args) {


    }


    /*
    不推荐
     */
    private static boolean method1(String str){

        return str.endsWith("a") == true;
    }

    /*
    推荐
     */
    private static boolean method2(String str){

        return str.endsWith("a");
    }


}
