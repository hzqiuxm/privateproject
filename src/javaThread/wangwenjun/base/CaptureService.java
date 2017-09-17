package javaThread.wangwenjun.base;

import java.util.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/4 0004 17:20
 */
public class CaptureService {

    final static private LinkedList<control> controls = new LinkedList<>();
    private  final static int MAX_WOEKER  = 5;

    public static void main(String[] args) {

        List<Thread> worker = new ArrayList<>();

        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10")
        .stream().map(CaptureService::createCaptureThread)
        .forEach(t->{
            t.start();
            worker.add(t);
        });

        worker.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture work is finished").ifPresent(System.out::println);

    }

    private static Thread createCaptureThread(String name){

        return new Thread(()->{
            Optional.of("The worker [ "+ Thread.currentThread().getName() + " ] begin capture data.").ifPresent(System.out::println);
            synchronized (controls){
                while (controls.size() > MAX_WOEKER){

                    try {
                        controls.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                controls.addLast(new control());


            }

            Optional.of("The worker " + Thread.currentThread().getName() + " is working now ......").ifPresent(System.out::println);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (controls){
                Optional.of("The worker [ "+ Thread.currentThread().getName() + " ] end capture data.").ifPresent(System.out::println);
                controls.removeFirst();
                controls.notifyAll();
            }

        },name);
    }

    private static class control{

//        Set<Integer> sets = Collections.synchronizedSet(new HashSet<>());
    }

}
