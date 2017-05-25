package java8new.wangwenjun.Collector;


import java.util.*;

import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/25 0025 15:35
 */
public class CollectorsAction {

    private final static
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH));

    public static void main(String[] args) {

        testAveragingDouble();
        testCollectingAndThen();
        testCounting();
        testGroupingBy();
        testGroupingByCollect();
        testSummarizingInt();

        testgroupingByConcurrent();
        testjoining();
        testmaxBy();
    }


    private static void testAveragingDouble(){

        System.out.println("-----------------------testAveragingDouble-------------------------");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)))
        .ifPresent(System.out::println);

    }

    private static void testCollectingAndThen(){

        System.out.println("-----------------------testCollectingAndThen-------------------------");
        Optional.ofNullable(menu.stream()
                .collect(Collectors.collectingAndThen(Collectors.averagingDouble(Dish::getCalories),aDouble -> "The Average is : " + aDouble)))
                .ifPresent(System.out::println);

    }

    private static void testCounting(){

        System.out.println("-----------------------testCounting-------------------------");
        Optional.ofNullable(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }


    private static void testGroupingBy(){

        System.out.println("-----------------------testGroupingBy-------------------------");
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType)))
        .ifPresent(System.out::println);

    }

    private static void testGroupingByCollect(){

        System.out.println("-----------------------testGroupingByCollect-------------------------");
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting())))
                .ifPresent(System.out::println);

    }

    private static void testSummarizingInt(){

        System.out.println("-----------------------testSummarizingInt-------------------------");
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingInt(Dish::getCalories)))
                .ifPresent(System.out::println);

    }


    //并发的
    private static void testgroupingByConcurrent(){

        System.out.println("-----------------------testgroupingByConcurrent-------------------------");
        Optional.ofNullable(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType)))
                .ifPresent(System.out::println);

    }


    private static void testjoining() {

        System.out.println("-----------------------testjoining-------------------------");
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",")))
                .ifPresent(System.out::println);

    }


    private static void testmaxBy() {

        System.out.println("-----------------------testmaxBy-------------------------");
        menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(System.out::println);


    }


}
