package javaThread.wangwenjun.design.readWriteLock;

import java.util.Random;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/28 0028 17:11
 */
public class WriteWorker extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final ShareData shareData;

    private final String filler;

    private int index = 0;


    public WriteWorker(ShareData shareData, String filler) {
        this.shareData = shareData;
        this.filler = filler;
    }

    @Override
    public void run() {

        try {

            while (true){
                char c = nextChar();
                shareData.write(c);
                Thread.sleep(random.nextInt(100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c = filler.charAt(index);
        index++;
        if(index>=filler.length()){
            index = 0;
        }

        return c;
    }
}
