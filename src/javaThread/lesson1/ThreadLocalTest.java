package javaThread.lesson1;

import java.util.Random;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/27 0027 19:28
 * 使用ThreadLocal实现线程内变量共享,一种很优雅的写法,把ThreadLocal封装在类的内部
 */
public class ThreadLocalTest {

    static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int data = new Random().nextInt();
                            System.out.println(Thread.currentThread().getName()
                                    + "has data : " + data );
                            x.set(data);

                            MyThreadScopeData.getThreadInstance().setName("hzqiuxm"+data);
                            MyThreadScopeData.getThreadInstance().setAge(data);

                            new A().get();
                            new B().get();
                        }
                    }
            ).start();
        }

    }

    static  class A{

        public void get(){

            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println(Thread.currentThread().getName() + "A get data " + x.get());
            System.out.println(Thread.currentThread().getName() + "A get myData " + myData.getAge() + myData.getName());
        }

    }

    static  class B{

        public void get(){
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println(Thread.currentThread().getName() + "B get data " + x.get());
            System.out.println(Thread.currentThread().getName() + "B get myData " + myData.getAge() + myData.getName());
        }
    }


}

//这个类对象天生就是和线程绑定的
 class MyThreadScopeData{

    private MyThreadScopeData(){}
    public static  MyThreadScopeData getThreadInstance(){

        //这样写就是获得了与本线程相关的实例
        MyThreadScopeData instance =tl.get();

        if(instance==null){
            instance = new MyThreadScopeData();
            tl.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> tl = new ThreadLocal<MyThreadScopeData>();

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}