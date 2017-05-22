package java8new.wangwenjun.three;

import java.util.Optional;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/18 0018 10:28
 */
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
