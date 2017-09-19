package javaThread.wangwenjun.design.ThreadLocal;

import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/9/18 0018 14:09
 */
public class Client {

    public static void main(String[] args) {

        IntStream.range(1,5).forEach(
                i -> new Thread(new ExecutionTask()).start()
        );

    }


}
