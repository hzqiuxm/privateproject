package javaThread.wangwenjun.base.BankTick;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/7/18 0018 16:56
 */
public class TicketWindow implements Runnable{

    private final static int max = 1000;
    private int index = 1;

    @Override
    public void run() {

        while (index<=max){
            System.out.println(Thread.currentThread() + "柜台叫号，当前的号码是：" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
