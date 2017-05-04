package java8new.wangwenjun.streampdf.forkjoin;

import org.junit.Test;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 15:01
 */
public class SimpleTest {

    @Test
    public void testTradition(){

        long startTime = System.currentTimeMillis();
        int start = 0;
        int end = 1500000;
        int sum = 0;

        for (int i=start; i<end; i++){
            sum += i;
        }

        System.out.println("Tradition Result = " + sum + " use time : " + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testforkjoin(){
        ConcurrencyCalculator cc = new ConcurrencyCalculator(0,1500000);
        long startTime = System.currentTimeMillis();

        System.out.println("Forkjoin Result = "  + cc.compute() + " use time : " + (System.currentTimeMillis() - startTime));
    }

}
