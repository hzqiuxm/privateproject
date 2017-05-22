package java8new;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/28 0028 16:21
 * 用Stream操作person
 */
public class StreamTest {
    public static void main(String[] args) throws InterruptedException {
        List<Person> people = createPeople();
        Stream<Person> streamp = people.stream();
        streamp.forEach(p-> System.out.println(p.toString()));

        System.out.println("-------------------------------------------------");

        List<Person> people2 = createPeople();
        people2.stream().filter(p->p.getGender()== Person.Sex.FEMALE)
                .forEach(p-> System.out.println(p.toString()
        ));

    }

    static List<Person> createPeople(){
        List<Person> people = new ArrayList<>();

        Person p1 = new Person("李四", Person.Sex.MALE,33,180);
        Person p2 = new Person("张三", Person.Sex.FEMALE,38,175);
        Person p3 = new Person("王五", Person.Sex.MALE,31,168);

        people.add(p1);
        people.add(p2);
        people.add(p3);

        return people;
    }
}
