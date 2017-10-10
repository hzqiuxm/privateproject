package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 16:12
 *
 */

/**
 *  {@link ActiveObject#makeString(int, char)}
 */
public class MakeStringRequest extends MethodRequest{

    private final int count;
    private final char fillChar;

    protected MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar, int count1, char fillChar1) {
        super(servant, futureResult);
        this.count = count1;
        this.fillChar = fillChar1;
    }

    @Override
    public void extcture() {

        AOResult result = servant.makeString(count, fillChar);
        futureResult.setResult(result);

    }
}
