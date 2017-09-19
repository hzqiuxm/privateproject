package javaThread.wangwenjun.design.balkingData;

import java.io.IOException;
import java.util.Random;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/19 0019 14:30
 */
public class CustomerThread extends Thread {

    private final BalkingData balkingData;
    private final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(BalkingData balkingData) {
        super("customer");
        this.balkingData = balkingData;
    }


    @Override
    public void run() {

        try {
            balkingData.save();

            for (int i = 0; i < 20; i++) {

                balkingData.change("new " + i);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balkingData.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
