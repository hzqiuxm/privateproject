package java8new.wangwenjun.AdvanceAction;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/2 0002 10:19
 */
public interface testInterface {

     void add();

    default void delete(){
        System.out.println("delete......");
    }

    default void update(){};
}
