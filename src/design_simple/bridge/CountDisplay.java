package design_simple.bridge;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/3/15 16:32
 * 功能结构的子类，继承关系
 */
public class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times){

        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
