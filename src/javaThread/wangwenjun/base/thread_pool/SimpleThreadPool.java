package javaThread.wangwenjun.base.thread_pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/14 0014 21:12
 */
public class SimpleThreadPool {

    private final int size;

    private final static int DEFAULT_SIZE = 10;

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private static volatile int seq = 0;

    private final static String SIMPLE_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("POOL_GROUP");

    private final static List<WorkerTask> THREAD_QUEUES = new ArrayList<>();

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void init() {

        for (int i = 0; i <size ; i++) {
            createWorkTask();
        }

    }

    //往队列中提交任务
    public void submit(Runnable runnable){

        synchronized (TASK_QUEUE){
             TASK_QUEUE.addLast(runnable);
             TASK_QUEUE.notifyAll();
        }

    }

    private void createWorkTask(){

        WorkerTask workerTask = new WorkerTask(GROUP,SIMPLE_PREFIX + (seq++));
        workerTask.start();
        THREAD_QUEUES.add(workerTask);

    }

    private enum TaskState{
        FREE,RUNNING,BLOCKED,DEDA
    }

    private static class WorkerTask extends Thread{

        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState(){
            return  this.taskState;
        }

        public WorkerTask(ThreadGroup threadGroup,String name){

            super(threadGroup,name);
        }


        public void run(){

            OUTER:
            while(this.taskState != TaskState.DEDA){
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {

                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }

                    runnable = TASK_QUEUE.removeFirst();

                }

                if(runnable!=null){
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }


            }

        }

        public void close(){
            this.taskState = TaskState.DEDA;
        }

    }


    public static void main(String[] args) {

        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();

        IntStream.rangeClosed(0,40)
                .forEach(i->{
                    simpleThreadPool.submit( ()-> {
                        System.out.println("The runnable " + i + " be serviced by " + Thread.currentThread() + " start ... ");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("The runnable " + i + " be serviced by " + Thread.currentThread() + " finished!");
                    });
                });
    }
}
