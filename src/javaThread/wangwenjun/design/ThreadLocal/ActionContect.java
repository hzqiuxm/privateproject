package javaThread.wangwenjun.design.ThreadLocal;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/18 0018 14:31
 */
public class ActionContect {


    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){

        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    public static class ContextHolder{

        private final static ActionContect actionContext = new ActionContect();

    }

    public static ActionContect getActionContext(){

        return ContextHolder.actionContext;
    }

    public Context getContext(){
        return threadLocal.get();
    }
}
