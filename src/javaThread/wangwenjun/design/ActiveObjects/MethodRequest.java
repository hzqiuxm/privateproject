package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 15:51
 * 对应ActiveObjectg中的每一个方法
 */
public abstract class MethodRequest {

    protected final Servant  servant;

    protected final FutureResult futureResult;

    protected MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }


    public abstract void extcture();
}
