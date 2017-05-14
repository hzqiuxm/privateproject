package jbase.jhl.example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/14 0014 10:07
 */
public class MyString  {

    public static void main(String[] args) {

        List<String> strlist = Arrays.asList(
                new String("jshdduiwe-sklasjhr-wqeqw-weqwe-cc-zxcs-q-weq-wd"),//8
                new String("nnfsd-sxfser-safser-sss-bbb-qwq-"),//6
                new String("iuir8e-d123-sadasd-123-saq"),//4
                new String("dhakjhw-ewq-eqw-eqw-q-w-q-w-ec-cxc-a-w-g-d-sfs-sf--fa-n"),//18
                new String("d-fdsf-fds-f-qwe-s-v-sdf-sds-fd-sfw-m")//11
        );


        System.out.println("=====排序前的顺序===== ：" );
        strlist.stream().forEach(out::println);
        Collections.sort(strlist,new MyCompare());
        System.out.println("=====排序后的顺序===== ：" );
        strlist.stream().forEach(out::println);

    }

}
