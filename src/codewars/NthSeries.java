package codewars;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/14 0014 20:52
 */
public class NthSeries {

    public static String seriesSum(int n) {

        return String.format("%.2f", IntStream.range(0, n).mapToDouble(num -> 1.0 / (1 + num * 3)).sum());
    }



    public static void main(String[] args) {

//        System.out.println(seriesSum(59));

//        System.out.println(getCount("asera"));
//        System.out.println(isSquare(4));
//        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps ff d"));

    }

    //a,e,i,o,u
    public static int getCount(String str) {
        int vowelsCount = 0;
//        char[] temp = str.toCharArray();
//
//        for (int i = 0; i < temp.length; i++) {
//
//            switch (temp[i]){
//                case 'a': vowelsCount++;continue;
//                case 'e': vowelsCount++;continue;
//                case 'i': vowelsCount++;continue;
//                case 'o': vowelsCount++;continue;
//                case 'u': vowelsCount++;continue;
//            }
//        }
//        return str.replaceAll("(?i)[^aeiou]", "").length();


        for(char c : str.toCharArray())
            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return vowelsCount;
    }

    public static boolean isSquare(int n) {

        int m = (int) Math.sqrt(n);

        return (m*m == n); // fix me!
    }

    public static int findShort(String s) {

        return Arrays.stream(s.split(" ")).mapToInt(value -> value.length()).min().getAsInt();

    }

}
