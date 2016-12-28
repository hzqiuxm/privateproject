package java8new;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/28 0028 16:49
 */
public class DoubleStreamTest {

    public static void main(String[] args) {

        List<Person> people = createPeople();
       Double davg =  people.stream().filter(p->p.getName().indexOf("五")>=0)
                .mapToDouble(p->p.getHeight())//获取一个double类型的数据源
                .average()
                .getAsDouble();

        System.out.println("包含王字的所有的身高的平均值:"+ davg);

    }

    static List<Person> createPeople(){
        List<Person> people = new ArrayList<>();

        Person p1 = new Person("李四", Person.Sex.MALE,33,1.8);
        Person p2 = new Person("张三", Person.Sex.FEMALE,38,1.75);
        Person p3 = new Person("王五", Person.Sex.MALE,31,1.68);
        Person p4 = new Person("钱五", Person.Sex.FEMALE,31,1.78);

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);

        return people;
    }
}
