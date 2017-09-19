package javaThread.wangwenjun.design.ThreadLocal;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/18 0018 14:00
 */
public class QueryFromHttpAction {

    public void execute(){

        Context context = ActionContect.getActionContext().getContext();
        String name = context.getName();
        String idNum = getIdNumbyName(name);

        context.setIDNum(idNum);

    }


    private String getIdNumbyName(String name) {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "330821 "+Thread.currentThread().getId();
    }
}
