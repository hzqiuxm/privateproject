package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 19:22
 */
public class DisplayStringRequest extends MethodRequest {

    private final String text;

    protected DisplayStringRequest(Servant servant, final  String text) {
        super(servant, null);
        this.text = text;
    }

    @Override
    public void extcture() {

        servant.displayString(text);
    }
}
