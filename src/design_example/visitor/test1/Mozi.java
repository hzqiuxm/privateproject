package design_example.visitor.test1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/10/6 0006 22:14
 */
public class Mozi {

    public void ride(Horse horse){
        System.out.println("骑马");
    }

    public void ride(WhiteHorse whiteHorse){

        System.out.println("骑白马");
    }

    public void ride(BlackHorse blackHorse){

        System.out.println("骑黑马");
    }

    public static void main(String[] args) {

        Horse whiteHorse = new WhiteHorse();
        Horse blackHorse = new BlackHorse();

        Mozi mozi = new Mozi();
        mozi.ride(whiteHorse);
        mozi.ride(blackHorse);
    }
}
