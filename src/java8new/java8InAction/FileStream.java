package java8new.java8InAction;

import java8new.wangwenjun.Collector.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/19 0019 10:18
 */
public class FileStream {
    public static void main(String[] args){

//        FileCount();

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

//        long count = menu.stream().collect(Collectors.counting());
//        System.out.println(count);

        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));

        System.out.println(collect);

    }

    private static void FileCount() {
        long uniqueWords = 0l;


        try(Stream<String> lines = Files.lines(Paths.get("E:\\testdata\\data2.txt"), StandardCharsets.ISO_8859_1)){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println(uniqueWords);
    }
}
