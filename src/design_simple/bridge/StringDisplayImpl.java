package design_simple.bridge;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/3/15 16:32
 * 实现层次结构的实现类（实现关系）
 */
public class StringDisplayImpl implements DisplayImpl {
    @Override
    public void rawOpen() {

        System.out.println(this.getClass().getName()+" rawOpen() ");
    }

    @Override
    public void rawPrint() {

        System.out.println(this.getClass().getName()+" rawPrint() ");

    }

    @Override
    public void rawClose() {

        System.out.println(this.getClass().getName()+" rawClose() ");

    }
}
