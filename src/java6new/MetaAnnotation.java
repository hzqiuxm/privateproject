package java6new;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/21 0021 20:19
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MetaAnnotation {
    String value() default "Meta";
}
