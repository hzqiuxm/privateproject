package design_simple.bridge;

import java.util.Random;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/3/15 16:47
 */
public class RandomDisplay extends Display {

    private Random random = new Random();

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times){

        int randomTimes = random.nextInt(times);

        open();

        for (int i = 0; i < randomTimes; i++) {

            print();
        }

        close();
    }
}
