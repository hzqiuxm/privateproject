package java8new.wangwenjun.streampdf.streambase;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 16:19
 * Stream的Intermediate（中间媒介）操作，可以有多个
 * Terminal(最终)操作，只能有一个
 */
public class StreamTest {

    //Map
    @Test
    public void testmap(){
        int[] array = {1,2,3,4,5};
        IntStream.of(array).map(operand -> operand * 10).forEach(value -> System.out.println(value));
    }

    //filter
    @Test
    public void testfilter(){

        Integer[] array = {1,2,3,4,5};
        List<Integer> integers = Stream.of(array).filter(integer -> integer < 4)
                .collect(Collectors.toList());
        integers.stream().forEach(integer -> System.out.println(integer));
    }

    //Distict
    @Test
    public void testDistinc(){
        Integer[] array = {1,2,3,4,4,1,5,6,3};
//        Arrays.stream(array).forEach(integer -> System.out.println(integer));
        Assert.assertEquals(9,array.length);

        List<Integer> integers = Stream.of(array).distinct().collect(Collectors.toList());
//        integers.stream().forEach(integer -> System.out.println(integer));
        Assert.assertEquals(6,integers.size());

    }

    //Sorted
    @Test
    public void testSorted(){
        Integer[] array = {2,6,3,1,8,7,9,5,4};
        Stream.of(array).sorted().forEach(integer -> System.out.println(integer));
    }

    //peek
    @Test
    public void testPeek(){
        Integer[] array = {2,6,3,1,8,7,9,5,4};
        List<Integer> integers = Stream.of(array).filter(integer -> integer%2 ==0)
                .peek(integer -> System.out.println(integer)).collect(Collectors.toList());

        System.out.println(integers);
    }

    //limit只获取流中的前n个元素，并且形成一个新的流返回
    @Test
    public void testLimit(){
        Integer[] array = {3,4,6,1,8,2};
        Stream.of(array).limit(4).forEach(e -> System.out.println(e));
    }

    //SKIPskip 则是跳过前面的几个元素形成一个新的流
    @Test
    public void testSkip(){
        Integer[] array = {3,4,6,1,8,2};
        Stream.of(array).skip(3).forEach(e -> System.out.println(e));
    }


}
