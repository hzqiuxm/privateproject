package javaThread.wangwenjun.design.balkingData;

import java.io.IOException;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/19 0019 14:41
 * 负责巡视的类
 */
public class WaitService extends Thread{

    private final BalkingData balkingData;


    public WaitService(BalkingData balkingData) {
        super("waitService");
        this.balkingData = balkingData;

    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {

            try {
                balkingData.save();
                Thread.sleep(1_000L);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
