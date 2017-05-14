package jbase.jhl.example3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/14 0014 11:07
 */
public class Main {

    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
                new Customer("hzqiuxm",17,"shengshijiayuan"),
                new Customer("handan",29,"taoyuanxiaozhen"),
                new Customer("hzqiuxm",10,"feicuicheng"),
                new Customer("hzqiuxm",17,"taoyuanxiaozhen")
        );

        Comparator<Customer> byName = Comparator.comparing(Customer::getName);

        customers.sort(byName
                .thenComparing(Customer::getAge)
                .thenComparing(Customer::getAddress));

        customers.forEach(out::println);


        //中文拼音排序,不是试题范围，仅做参考
        List<Customer> customers2 = Arrays.asList(
                new Customer("张三",17,"shengshijiayuan"),
                new Customer("李四",29,"taoyuanxiaozhen"),
                new Customer("王五",10,"feicuicheng"),
                new Customer("赵六",17,"taoyuanxiaozhen"),
                new Customer("张三",17,"taoyuanxiaozhen"),
                new Customer("张三",12,"shengshijiayuan")
        );

        Collections.sort(customers2,new PinyinCompare()
                .thenComparing(Customer::getAge)
                .thenComparing(Customer::getAddress));

        customers2.forEach(out::println);

    }
}
