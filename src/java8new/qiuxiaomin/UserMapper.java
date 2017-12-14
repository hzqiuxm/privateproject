package java8new.qiuxiaomin;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/4 0004 16:16
 * 函数式接口测试
 */

@FunctionalInterface
public interface UserMapper {


     default void insert(){}


    public void get();
}
