package java8new.qiuxiaomin;

import java8new.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/5 0005 15:42
 */
public class StreamAPITest001 {

    public static void main(String[] args) {


//        OptionalInt max = Arrays.asList(1,2,3,4,5,6,7,8).stream().filter(i->i%2 != 0).mapToInt(x->x).max();
//
//        max.ifPresent(System.out::println);

//        Arrays.asList(1,2,3,4,5,6).stream().filter(i->i%2 == 0).forEach(System.out::println);

//        String compexStr = "userId=12345&userName=qiuxm&type=2&token=111111111111111&key=888";
//
//        Map<String, String> stringMap = Stream.of(compexStr.split("&"))
//                .map(s -> s.split("="))
//                .collect(Collectors.toMap(s -> s[0], s -> s[1]));
//
//        System.out.println(stringMap);


        List<Person> personList = createPeople();

        //将整数排序连接成一个字符串
        String collect = personList.stream()
                .map(person -> person.getAge() + "")
                .sorted()
                .collect(Collectors.joining(",","(",")"));

        System.out.println("collect = "+ collect);




        //对浮点数排序并去重
        Set<Double> doubleSet = personList.stream()
                .map(person -> person.getHeight())
                .sorted()
                .collect(Collectors.toSet());

        System.out.println("doubleSet = "+ doubleSet);


        //反向排序和多条件排序
        personList.stream()
                .sorted(Comparator.comparingDouble(Person::getHeight).reversed().thenComparing(Person::getAge))
                .forEach(System.out::println);

        //找出某个值最大的记录
        personList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getHeight)));

        //分类聚合
        Map<Person.Sex, List<Person>> sexListMap = personList.stream().collect(Collectors.groupingBy(Person::getGender));

        System.out.println(sexListMap);

        //分类统计
        Map<Person.Sex, Long> longMap = personList.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));

        System.out.println(longMap);

    }



    static List<Person> createPeople(){
        List<Person> people = new ArrayList<>();

        Person p1 = new Person("李四", Person.Sex.MALE,33,180);
        Person p2 = new Person("张三", Person.Sex.FEMALE,38,175);
        Person p3 = new Person("王五", Person.Sex.MALE,32,168);
        Person p4 = new Person("赵六", Person.Sex.MALE,33,164);
        Person p5 = new Person("沈七", Person.Sex.FEMALE,34,164);
        Person p6 = new Person("程八", Person.Sex.MALE,35,172);
        Person p7 = new Person("冯九", Person.Sex.FEMALE,36,179);
        Person p8 = new Person("金一", Person.Sex.MALE,37,182);
        Person p9 = new Person("范二", Person.Sex.FEMALE,38,172);

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
