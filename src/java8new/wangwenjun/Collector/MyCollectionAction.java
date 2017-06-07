package java8new.wangwenjun.Collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/1 0001 10:42
 */
public class MyCollectionAction {

    public static void main(String[] args) {


        Collector<String,List<String>,List<String>> collector = new MyToListCollector<>();

        String[] arrs = new String[]{"hzqiuxm","java","action","Collector","Tolist","Stream","Great"};

        List<String> strings = Arrays.stream(arrs).filter(s -> s.length() > 5).collect(collector);

        System.out.println(strings);

        System.out.println("----------------------------------------------------------------");

        List<String> list = Arrays.asList("hzqiuxm", "java", "action", "Collector", "Tolist", "Stream", "Great");

        List<String> collect = list.parallelStream().filter(s -> s.length() > 5).collect(collector);

        System.out.println(collect);


    }
}
