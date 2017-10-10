package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 15:53
 * 真正实现任务的类
 */
public class Servant implements ActiveObject {


    @Override
    public AOResult makeString(int count, char fillChar) {

         char [] buf = new char[count];
        for (int i = 0; i < count; i++) {
            buf[i] = fillChar;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new RealResult(new String(buf));
    }

    @Override
    public void displayString(String text) {

        try{
            System.out.println("Display: " + text);
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
