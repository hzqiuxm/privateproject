package javaThread.wangwenjun.design.ThreadLocal;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/18 0018 13:53
 */
public class QueryFromDbAction {

    public void execute(){

        try {
            Thread.sleep(1000L);
            String name = "hzqiuxm "+Thread.currentThread().getName();
            ActionContect.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
