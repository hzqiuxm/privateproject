package jbase.jhl.example3;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Comparator;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/14 0014 13:33
 * 实现汉语拼音排序
 */
public class PinyinCompare implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return ToPinYinString(o1.getName()).compareTo(ToPinYinString(o2.getName()));
    }

    /**
     * 汉语到拼音的转化
     * @param str
     * @return
     */
    public static String ToPinYinString(String str){

        StringBuilder sb = new StringBuilder();
        String[] arr = null;

        for (int i = 0; i < str.length(); i++) {
            arr = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i));
            if(arr!=null && arr.length>0){
                for(String string : arr){
                    sb.append(string);
                }
            }
        }

        return sb.toString();

    }



    public static void main(String[] args) {

        System.out.println(ToPinYinString("临江仙"));
    }
}
