package javaThread.wangwenjun.design;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/8/17 0017 14:46
 */
public class singleandenum {

    private singleandenum(){

    }

    private enum Singleton{
        INSTANCE;
        private final singleandenum instance;

        Singleton(){

            instance = new singleandenum();
        }

        public singleandenum getInstace(){

            return instance;
        }

    }

    public static singleandenum getInstace(){

        return Singleton.INSTANCE.getInstace();
    }

}
