package java8new.wangwenjun.streampdf.helloworld;

import org.junit.Test;

import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 14:49
 */
public class HelloWorldTest {

    @Test
    public void testIterator(){

        FruitSelector fruitSelector = new IteratorFruitSelector();

        List<Double> result = fruitSelector.select();
        System.out.println(result);
    }

    @Test
    public void testStream(){

        StreamSelector  streamSelector = new StreamSelector();
        List<Double> result = streamSelector.select();
        System.out.println(result);
    }
}
