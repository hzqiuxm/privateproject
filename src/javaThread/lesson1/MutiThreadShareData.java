package javaThread.lesson1;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 10:46
 * 多线程共享数据,设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
 */
public class MutiThreadShareData {

    public static void main(String[] args) {

        final  ShareData1 shareData1 = new ShareData1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData1.dec();
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {

                shareData1.inc();
            }
        }).start();
    }
}

class ShareData1{

   private int j = 0;


   public synchronized void inc(){

       j++;
   }

   public synchronized void dec(){

       j--;
   }

}



