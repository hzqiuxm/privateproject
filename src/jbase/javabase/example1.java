package jbase.javabase;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/15 0015 10:03
 * java 基本功代码示例
 */
public class example1 {


    /**
     * 编写一个程序实现 1 + 1/4 + 1/7 + 1/10 + ... 计算，当n=1时，程序输出1，
     * n=2时，程序输出1 + 1/4，以此类推，要求结果保留两位小数，请写出你的代码。
     * @param n
     * @return
     */
    public static String seriesSum(int n) {

        return String.format("%.2f", IntStream.range(0, n).mapToDouble(num -> 1.0 / (1 + num * 3)).sum());
    }


    /**
     * 编写一个程序，判断一个字符串里包含了多少个元音（a,e,i,o,u）字符
     * @param str
     * @return
     */
    public static int getCount(String str) {

        //第一种
//        return str.replaceAll("(?i)[^aeiou]", "").length();

        //第二种
        int vowelsCount = 0;

        for(char c : str.toCharArray())
            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return vowelsCount;

    }

    /**
     *编写一个程序，统计一段文字中，长度最小的单词，比如："my name is lilei"，返回值是2
     * @param s
     * @return
     */
    public static int findShort(String s) {

        return Arrays.stream(s.split(" ")).mapToInt(value -> value.length()).min().getAsInt();

    }


    public static void main(String[] args) {

    }
}
