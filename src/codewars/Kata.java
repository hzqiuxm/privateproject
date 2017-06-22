package codewars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/21 0021 17:33
 * Write a function that accepts an array of 10 integers (between 0 and 9),
 * that returns a string of those numbers in the form of a phone number.
 * Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 */
public class Kata {


    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(createPhoneNumber(ints));
    }

    public static String createPhoneNumber(int[] numbers) {

        String s1 = "";
        String s2= "";
        String s3 = "";
        for (int i = 0; i < 10; i++) {
            if(i<3){
               s1 += numbers[i];
            }
            if(i<7&&i>=3){
                s2 += numbers[i];
            }
            if (i>=7){
                s3+=numbers[i];
            }

        }

        return "("+ s1 +")"+" "+s2 + "-" + s3;
    }

    /*private static String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    public static String createPhoneNumber(int[] numbers) {
        Integer[] numbersInt = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        return String.format(PHONE_FORMAT, numbersInt);
    }*/
}
