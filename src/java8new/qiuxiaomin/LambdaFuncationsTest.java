package java8new.qiuxiaomin;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/4 0004 17:11
 */



public class LambdaFuncationsTest {

    private String name;

    public LambdaFuncationsTest(String s) {

        this.name = s;
        System.out.println("hello" + s);
    }

    public LambdaFuncationsTest() {

    }


    public static String tes1(){

        return "hello test1";
    }

    static int get(){
        return 1;
    }

    static void exec(){

    }



    public static void main(String[] args) throws Exception {


        Function<String,String> f1 = String::toUpperCase; //对象方法引用

        Consumer<String> c1 = System.out::println;//对象方法引用

        Supplier<String> s1 = LambdaFuncationsTest::tes1; //静态方法引用

        System.out.println(s1.get());

        Supplier<LambdaFuncationsTest> s2 = LambdaFuncationsTest::new; //无参构造方法引用

        Consumer<String> c2 = LambdaFuncationsTest::new;//有参构造方法应用

        Function<String,Account> f2 = Account::new; //带自定义参数的构造方法应用


//        Runnable r1 = () -> get();
//
//        Runnable r2 = () -> exec();

        /*Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello callable~ ";
            }
        };

        Callable<String> c2 = () -> "hello callable~";

        System.out.println(c1.call());

        System.out.println(c2.call());*/


/*        Function<Integer,Integer> function = integer -> {

            int sum = 0;
            for (int i = 0; i < integer; i++) {
                sum += i;
            }

            return sum;
        };


        System.out.println(function.apply(100));*/


/*        Predicate<String> predicate = s -> {

            return s.length()>5;
        };

        System.out.println(predicate.test("hello123"));*/

    }
}

class Account{

    public Account() {
    }

    public Account(String name){
        System.out.println("hello " +name);
    }
}