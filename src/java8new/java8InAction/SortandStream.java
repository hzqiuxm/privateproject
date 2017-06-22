package java8new.java8InAction;

import java8new.wangwenjun.Collector.Dish;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/15 0015 15:40
 */
public class SortandStream {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        List<String> lowCaloricDishesName =
                menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories).reversed())
                        .map(Dish::getName)
                        .collect(toList());

        System.out.println(lowCaloricDishesName);


        String[] words = {"Hello", "world"};
//        List<String> words = Arrays.asList("hello", "world");

        Arrays.stream(words).
                map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList()).forEach(out::println);

//
//        String[] strings1 = strings.get(0);
//        for (String s : strings1){
//            System.out.println(s);
//        }


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map(n->n*n).collect(toList()).forEach(out::println);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> ints = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());

        System.out.println(ints);


    }
}
