package java8new.wangwenjun.streampdf.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 15:43
 */
public class ConcurrencyCalculator extends RecursiveTask<Integer> {


    int start = 0;
    int end = 1500000;

    private final static int THRESHOLD = 5;

    public ConcurrencyCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if((end - start) < THRESHOLD){
            for (int x = start; x < end; x++) {
                sum += x;
            }
        }else {
            int middle = (start + end) / 2;
            ConcurrencyCalculator leftCalculator = new ConcurrencyCalculator(start, middle);
            ConcurrencyCalculator rightCalculator = new ConcurrencyCalculator(middle, end);
            leftCalculator.fork();
            rightCalculator.fork();
            sum += (leftCalculator.join() + rightCalculator.join());
        }
        return sum;
    }
}
