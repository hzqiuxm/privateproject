package javaThread.lesson1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/27 0027 14:03
 * 传统定时器
 */
public class TraditionalTimerTest {
    public static void main(String[] args) throws Exception{

        //第一次1秒后执行，之后每隔2秒执行
//        new Timer().schedule(new TimerTask() {
//            int i;
//            @Override
//            public void run() {
//                System.out.println("boming!" + i++);
//            }
//        },1000,2000);


        //

        class MyTimerTask extends TimerTask{

            @Override
            public void run() {
                System.out.println("boming!");

                new Timer().schedule(new MyTimerTask(),2000);
            }
        }

        new Timer().schedule(new MyTimerTask(),1000);

        while (true){
            System.out.println(new Date().getSeconds());

            Thread.sleep(1000);
        }
    }
}
