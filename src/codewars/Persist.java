package codewars;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/21 0021 9:49
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 * For example:
 * persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
// and 4 has only one digit
 */
public class Persist {


    public static void main(String[] args) {
        System.out.println(persistence(999));
    }


    public static int persistence(long n) {

        int i = 0;
        while (n>9){
            n = transferNumber(n);
            i++;
        }
        return i;

    }

    public static long transferNumber(long n){

        String[] strings = String.valueOf(n).split("");
        return Arrays.stream(strings).mapToInt(Integer::valueOf).reduce((i, j) -> i * j).getAsInt();

    }
}
