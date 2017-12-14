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
        Person p3 = new Person("王五", Person.Sex.MALE,32,168);
        Person p4 = new Person("赵六", Person.Sex.MALE,33,161);
        Person p5 = new Person("沈七", Person.Sex.MALE,34,164);
        Person p6 = new Person("程八", Person.Sex.MALE,35,172);
        Person p7 = new Person("冯九", Person.Sex.MALE,36,179);
        Person p8 = new Person("金一", Person.Sex.MALE,37,182);
        Person p9 = new Person("范二", Person.Sex.MALE,38,177);

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
        people.add(p7);
        people.add(p8);
        people.add(p9);

        return people;
    }
}
