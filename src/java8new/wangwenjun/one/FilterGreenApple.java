package java8new.wangwenjun.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/14 0014 11:13
 * 让参数具备行为能力
 */
public class FilterGreenApple {

    //当需求是需要根据颜色，重量结合筛选，一般会采用策略者模式
    @FunctionalInterface //使用了该注解后,若接口中多于一个方法就会报错
    public  interface FilterCondition{
        boolean filter(Apple apple);

    }


    //写一个按照绿色和150重量筛选的类
    public static class GreenColorand150Weight implements FilterCondition{

        @Override
        public boolean filter(Apple apple) {

            if(apple.getColor().equals("green")&&apple.getWeight()>=150){
                return true;
            }
            return false;
        }
    }

    //最不灵活的写法
    public static List<Apple> getGreemApple(List<Apple> apples){

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples){
            if("green".equals(apple.getColor())){
                list.add(apple);
            }
        }

        return list;

    }

    //只适合颜色变化的筛选
    public static List<Apple> getApple(List<Apple> apples,String color){

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples){
            if(color.equals(apple.getColor())){
                list.add(apple);
            }
        }

        return list;

    }

    //策略模式写法
    public static List<Apple> getApple(List<Apple> apples,FilterCondition filterCondition){

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples){
            if(filterCondition.filter(apple)){
                list.add(apple);
            }
        }

        return list;

    }

    public static void main(String[] args) throws InterruptedException {

        List<Apple> apples = Arrays.asList(new Apple("green",150),new Apple("red",100),
                new Apple("red",150),new Apple("green",100));

//        FilterGreenApple filterGreenApple = new FilterGreenApple();
//        filterGreenApple.getGreemApple(apples);
//        System.out.println(getGreemApple(apples));
//        System.out.println(getApple(apples,"red"));

        List<Apple> list = getApple(apples, new GreenColorand150Weight());
        System.out.println(list);

        //Lambda表达式(要求接口有且只有一个方法,default方法除外)
        List<Apple> lambdaResult = getApple(apples, (apple) -> {
            return apple.getColor().equals("red");
        });

        System.out.println(lambdaResult);


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("name is :" + Thread.currentThread().getName());
            }
        }).start();

        new Thread(()-> System.out.println("name is :" + Thread.currentThread().getName())).start();


        Thread.currentThread().join();

    }

}
