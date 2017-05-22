package java8new.wangwenjun.one;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/17 0017 20:03
 */
@FunctionalInterface
public interface ThreeFuncation<T,U,K,R> {

    R apply(T t, U u,K k);

}
