package java6new;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/23 0023 9:38
 */
public class GenericTest {

    public static void main(String[] args) throws Exception{

        ArrayList<Integer> collection1 = new ArrayList<>();
        ArrayList<String> collection2 = new ArrayList<>();


        System.out.println(collection1.getClass() == collection2.getClass());

        //编译后的字节码是会去掉泛型的，利用反射可以在Integer的ArrrayList中加入String
        //直接存字符串的值是会错的，编译器
//        collection1.add("abc");
        collection1.getClass().getMethod("add",Object.class).invoke(collection1,"abc");
        System.out.println(collection1.get(0));

        Vector v1 = new Vector<String>();
        Vector<Object> v = v1;

        printMap();

    }

    //打印任意参数化类型的集合
    public static void printCollection(Collection<?> collection){

//        collection.add("abc"); //会报错
        System.out.println(collection.size());
        for (Object obj:collection){
            System.out.println(obj);
        }
    }

    //利用Map.Entry来打印Map
    public static void printMap() throws Exception{

        HashMap<String ,Integer> maps = new HashMap<String, Integer>();
        maps.put("hzqiuxm",30);
        maps.put("linjiangxian",31);
        maps.put("handan",25);

        Set<Map.Entry<String,Integer>> entrySet = maps.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        //用迭代器遍历
        Iterator<Map.Entry<String,Integer>> itor = maps.entrySet().iterator();
        while (itor.hasNext()){
            Map.Entry<String,Integer> e = itor.next();
            System.out.println(e.getKey() + "-" + e.getValue());
        }


    }
}
