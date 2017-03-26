package java6new.aopFrame;

import java.lang.reflect.Method;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/26 0026 11:32
 */
public class MyAdvice implements Advice {
    private long beginTime;
    private long endTime;

    @Override
    public void beforeMethod(Method method) {
        System.out.println("begin time is ready!");
        beginTime = System.currentTimeMillis();

    }

    @Override
    public void afterMethod(Method method) {
        System.out.println("end time is ready!");
        endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " run time is " + (endTime - beginTime));
    }
}
