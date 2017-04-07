package javaJVM.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/7 0007 14:28
 * java软引用示例  -Xms5m -Xmx13m -XX:PrintGCDetails
 */
public class Test001 {

    private static ReferenceQueue<User> rq = new ReferenceQueue<User>();

    private static void printQueue(){
        Reference<? extends User> obj = rq.poll();
        if(null!=obj){
            System.out.println("the obj is =====" + obj);
        }
    }

    public static void main(String[] args) throws Exception{

        List<SoftReference<User>> userlists = new ArrayList<SoftReference<User>>();

        for (int i = 0; i < 10; i++) {
            SoftReference<User> sr = new SoftReference<User>(new User("hzqiuxm"+i),rq);
            System.out.println("now user is : " + sr.get());

            userlists.add(sr);
        }

        System.gc();
        Thread.sleep(1000);
        printQueue();


    }
}
