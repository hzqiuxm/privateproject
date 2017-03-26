package java6new.aopFrame;

import java.lang.reflect.Method;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/26 0026 11:28
 */
public interface Advice {

     void beforeMethod(Method method);

     void afterMethod(Method method);
}
