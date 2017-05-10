package java_base.firebug;

import java.util.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/9 0009 11:27
 *  * 测试keySet()与entrySet()的迭代时间
 * keySet():迭代后只能通过get()取key
 * entrySet()：迭代后可以e.getKey()，e.getValue()取key和value。返回的是Entry接口
 * 最后发现keySet()的速度比entrySet()慢了很多。2-3倍
 */
public class entrySetandkeyset {

    public static void main(String[] args) {

        HashMap<String,String> kmap = new HashMap<String,String>();
        HashMap<String,String> emap = new HashMap<String,String>();

        for (int i = 0; i <1000; i++) {
            kmap.put(""+i,"KEYSET");
        }

        for (int i = 0; i < 1000; i++) {
            emap.put(""+i,"ENTRYSET");
        }

        long stimes = System.currentTimeMillis();

        Iterator<String> ktor = kmap.keySet().iterator();
        while (ktor.hasNext()){
            System.out.println(kmap.get(ktor.next()));
        }

        long etimes = System.currentTimeMillis();

        System.out.println("time 1 = " + (etimes-stimes));//30ms

        long s2times = System.currentTimeMillis();

        Iterator<Map.Entry<String,String>> itor = emap.entrySet().iterator();
        while (itor.hasNext()){
            Map.Entry<String,String> e = itor.next();

//            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        long e2times = System.currentTimeMillis();
        System.out.println("time 2 = " + (e2times-s2times));//9ms




    }
}
