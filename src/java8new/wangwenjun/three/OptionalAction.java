package java8new.wangwenjun.three;

import java.util.Optional;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/18 0018 14:06
 */
public class OptionalAction {

    public static void main(String[] args) {

        String nameByOpational = getInstranceNameByOpational(null);

        System.out.println(nameByOpational);

    }

    private static String getInstranceNameByOpational(Person person){

        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsuracne)
                .map(Insuracne::getName).orElse("unknown");

    }


}
