package java8new.qiuxiaomin;

import java.util.*;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/11/16 0016 15:39
 */
public class JavaBaseTest {

    public static void main(String[] args) {


//        jinzhiTranfer();

        String[] names = {"hello","world"};

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(names));

        arrayList.forEach(System.out::println);

        List<String> strings = Arrays.asList("qiuxm", "youming", "dingding");

    }

    private static void jinzhiTranfer() {
        int n = 42;
        String str1 = "42";
        String str2 = "101010";
        int m;

        System.out.println(Integer.toString(n,16));
        m = Integer.parseInt(str2,2);

        System.out.println("m = " + m);
    }
}
