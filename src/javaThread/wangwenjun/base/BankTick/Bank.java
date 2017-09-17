package javaThread.wangwenjun.base.BankTick;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/7/18 0018 16:57
 */
public class Bank {

    public static void main(String[] args) {

       final TicketWindow ticketWindow = new TicketWindow();
        int i =1;
        while (i<4){

            new Thread(ticketWindow,i+"号窗口").start();
            i++;
        }

    }
}
