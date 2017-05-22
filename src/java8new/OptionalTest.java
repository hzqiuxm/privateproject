package java8new;

import java.util.Optional;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/15 0015 20:17
 */
public class OptionalTest {

    public static void main(String[] args) {

        Optional<Person> person = null;

        System.out.println(person);

    }

    public Person getPerson(){

        Optional<Person> person = Optional.of(new Person("hzqiuxm", Person.Sex.FEMALE, 18, 17.5));

        return person.orElse(null);

    }
}
