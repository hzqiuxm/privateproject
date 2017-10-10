package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 15:17
 * 接收异步消息的主动方法
 */
public interface ActiveObject {

    AOResult makeString(int count,char fillChar);

    void displayString(String text);
}
