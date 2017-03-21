package java6new;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/21 0021 12:14
 */
@Retention(RetentionPolicy.RUNTIME)//元注解
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface HelloAnnotation {

    String value();//为注解添加属性,只有value属性，可省略
    String color() default "red";
    int[] arrayAttr();
    TrafficLamp lamp() default TrafficLamp.RED;
    MetaAnnotation meta() default @MetaAnnotation("time");
}
