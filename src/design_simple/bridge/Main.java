package design_simple.bridge;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/3/15 16:43
 * 桥接模式的重点就是区分出功能层次结构和实现层次结构，然后功能类聚合层次接口
 */
public class Main {

    public static void main(String[] args) {

        Display d1 = new Display(new StringDisplayImpl());

        CountDisplay d2 = new CountDisplay(new StringDisplayImpl());

        RandomDisplay d3 = new RandomDisplay(new StringDisplayImpl());

        d1.display();

        System.out.println("------------------");

        d2.multiDisplay(10);

        System.out.println("------------------");

        d3.randomDisplay(10);
    }
}
