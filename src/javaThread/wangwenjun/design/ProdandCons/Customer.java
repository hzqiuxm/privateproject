package javaThread.wangwenjun.design.ProdandCons;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/20 0020 10:19
 * 消费者
 */
public class Customer extends Thread {
    private final MessageQueue messageQueue;
    private final static Random random = new Random(System.currentTimeMillis());
    private final static AtomicInteger counter = new AtomicInteger(0);

    public Customer(MessageQueue messageQueue,int seq) {
        super("Customer-" + seq);
        this.messageQueue = messageQueue;

    }


    @Override
    public void run() {

        while (true){

            try {
                Message message = messageQueue.get();
                System.out.println(Thread.currentThread().getName() + "get message " + message);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
