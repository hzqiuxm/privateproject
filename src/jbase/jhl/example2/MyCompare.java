package jbase.jhl.example2;

import java.util.Comparator;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/14 0014 10:32
 */
public class MyCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(countSpecNum(o1)>countSpecNum(o2)){
            return -1;
        }else if(countSpecNum(o1)<countSpecNum(o2)){
            return 1;
        }else {
            return 0;
        }
    }

    public static int countSpecNum(String str){

        String spec = "-";
        String[] tempstr = str.split(spec);

        return tempstr.length;
    }

}
