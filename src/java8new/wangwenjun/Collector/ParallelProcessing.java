package java8new.wangwenjun.Collector;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/1 0001 11:01
 */
public class ParallelProcessing {

    public static void main(String[] args) {

//        long totalMemory = Runtime.getRuntime().totalMemory();
//
//        int i = Runtime.getRuntime().availableProcessors();
//
//        System.out.println("totalMemory = " + totalMemory/(1024*1024) + ", cpu : "+ i );

//        System.setProperty("","12");

        System.out.println("The Normal : " + measureSumPerformance(ParallelProcessing::nomalAdd,1_000_000_000L));

//        System.out.println("-----------------1------------------");
//
//        System.out.println("The iterateStream : " + measureSumPerformance(ParallelProcessing::iterateStream,100_000_000L));

//        System.out.println("------------------2-----------------");
//
//        System.out.println("The iterateStream : " + measureSumPerformance(ParallelProcessing::iterateParalelStream,10_000_000L));

        System.out.println("------------------3-----------------");
        System.out.println("The iterateStream : " + measureSumPerformance(ParallelProcessing::ParallelLongStream,1_000_000_000L));


    }

    private static long measureSumPerformance(Function<Long,Long> adder, long limit){

        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            long result = adder.apply(limit);
            long duration = System.currentTimeMillis() - startTime;

            System.out.println("The result is : " + duration);
            if(duration<fastest){
                fastest = duration;
            }
        }

        return fastest;

    }

    //有点慢
    private static long iterateStream(long limit){

        return Stream.iterate(1L,i->i+1).limit(limit).reduce(0L,Long::sum);
    }


    //慢的有点过分
    private static long iterateParalelStream(long limit){

        return Stream.iterate(1L,i->i+1).parallel()
                .limit(limit).reduce(0L,Long::sum);
    }

    //非常快
    private static long ParallelLongStream(long limit){

        return LongStream.rangeClosed(1,limit).parallel().sum();
    }

    //很快
    private static long nomalAdd(long limit){
        
        long result = 0L;
        for (long i = 1L; i < limit ; i++) {
            result += i;
        }
        return result;
    }
}
