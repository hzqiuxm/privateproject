package design_simple.bridge;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/3/15 16:31
 * 功能结构的顶层类
 */
public class Display {

    //功能层次结构和实现层次结构的桥梁
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open(){
        impl.rawOpen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){

        open();
        print();
        close();
    }
}
