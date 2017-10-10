package javaThread.wangwenjun.design.ActiveObjects;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/28 0028 16:06
 */
public class FutureResult implements AOResult {

    private AOResult result;

    private boolean ready = false;

    public synchronized void setResult(AOResult result){

        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    @Override
    public Object getResultValue() {

        while (!ready){

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultValue();
    }
}
