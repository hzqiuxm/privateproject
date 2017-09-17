package javaThread.wangwenjun.design.FutureThread;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/30 0030 15:58
 * 这里面的wait指的事其他事情做完，如果任务还没返回，在future中get的时候还是要等待的
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

//        waitMethod();

        noWaitMethod();
    }

    //异步轮询写法
    private static void waitMethod() throws InterruptedException {
        Service service = new Service();

        Future future = service.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "FINSH!";
        });


        System.out.println("=================");
        System.out.println("do other things......");
        Thread.sleep(1000);

        System.out.println("--------------------");

        System.out.println(future.get());
    }

    //callback写法
    private static void noWaitMethod() throws InterruptedException {
        Service service = new Service();

        service.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "FINSH!";
        },System.out::println);


        System.out.println("=================");
        System.out.println("do other things......");
        Thread.sleep(1000);

        System.out.println("--------------------");

    }


}
