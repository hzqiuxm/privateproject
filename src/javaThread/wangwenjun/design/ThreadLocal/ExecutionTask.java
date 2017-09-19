package javaThread.wangwenjun.design.ThreadLocal;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/18 0018 13:51
 * Thread Local 应用
 */
public class ExecutionTask implements Runnable{

    private QueryFromDbAction queryAction = new QueryFromDbAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {

        Context context = ActionContect.getActionContext().getContext();
        queryAction.execute();

        System.out.println("The name query successful ! ");
        httpAction.execute();
        System.out.println("The idNum query successful ! ");

        System.out.println("The name is : "+ context.getName() + " The idNum is : " + context.getIDNum());
    }
}
