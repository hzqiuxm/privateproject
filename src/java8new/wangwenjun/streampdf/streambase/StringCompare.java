package java8new.wangwenjun.streampdf.streambase;

import java8new.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/13 0013 20:16
 */
public class StringCompare {

    public static void main(String[] args) {

        List words1 = Arrays.asList("B", "H", "Q", "L", "A", "X", "C", "K");
        Collections.sort(words1);
        System.out.println(words1);


        List words2 = Arrays.asList("B", "H", "Q", "L", "A", "X", "C", "K");
        Collections.sort(words2,new Comp1());

        System.out.println(words2);

        List words3 = Arrays.asList("B", "H", "Q", "L", "A", "X", "C", "K");
        Collections.sort(words3,String::compareTo);
        System.out.println(words3);

    }


}
