package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 15:56
 */
public class RealResult implements AOResult {

    private final Object resultValue;


    public RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultValue() {
        return null;
    }
}
