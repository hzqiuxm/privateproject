package java8new.wangwenjun.streampdf.helloworld;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 13:49
 */
public class Fruit {

    private final String Name;
    private final double price;

    public Fruit(String name, double price) {
        Name = name;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }
}
