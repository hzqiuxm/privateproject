package jbase;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/1 0001 14:49
 * 测试cpu的多级缓存,不加volatile 的情况下，程序永远不会停止
 */
public class Main {

    public static /*volatile*/ boolean isStop = false;

    public static void main(String[] args) throws Exception{

        Thread thread = new Thread(){

            @Override
            public void run() {
                int i = 1;
                while (!isStop){
                    i++;
                }
                System.out.println("Thread stop i : " + i);
            }
        };

        thread.start();

        Thread.sleep(2000);
        isStop = true;
        System.out.println("now! isStop : " + isStop);

        thread.join();
    }
}
