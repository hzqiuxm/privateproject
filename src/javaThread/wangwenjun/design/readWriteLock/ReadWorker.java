package javaThread.wangwenjun.design.readWriteLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/29 0029 10:06
 */
public class ReadWorker extends Thread{


    private final ShareData shareData;


    public ReadWorker(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {

        try {
            while(true){
                char[] readBuf = shareData.read();
                System.out.println(Thread.currentThread().getName() + " reads : " + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
