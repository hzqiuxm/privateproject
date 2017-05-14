package java8new.wangwenjun.streampdf.streambase;

import java.util.Comparator;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/13 0013 20:40
 */
public class Comp1 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
    }
}
