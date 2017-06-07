package jbase.algorithm.example1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/7 0007 15:49
 */
public class Ball {

    public static void main(String[] args){
        double height =100;
        int time = 10;
        double distance = drop(height,time);
        System.out.println("distance="+distance);
    }

    public static double drop(double height,int times){
        double distance = 0.0;
        if(times>0){
            distance = height+height/2.0;
            System.out.println("height="+height/2);
            distance +=drop(height/2,times-1);
        }
        return   distance;
    }
}
