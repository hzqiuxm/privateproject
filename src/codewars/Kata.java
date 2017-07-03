package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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

//        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//
//        System.out.println(createPhoneNumber(ints));

//        findMissingLetter(new char[] { 'O','Q','R','S' });

//        System.out.println(89.0/89);
//        System.out.println(digPow(46288, 3));
          findUniq(new double[]{0, 1, 0});
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


    /**
     * ['a','b','c','d','f'] -> 'e'
     ['O','Q','R','S'] -> 'P
     * @param array
     * @return
     */
    public static char findMissingLetter(char[] array)
    {
        int first = array[0];
        int length = array.length;
        int last = array[array.length-1];
        int sum =0;
        int realSum = (first +last )*(last-first+1)/2;

        for (int i = 0; i <length; i++) {
            sum += array[i];
        }

        return (char) (realSum - sum);
    }

    public static int[] sortArray(int[] array) {
        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }

        return array;
    }

    public static long digPow(int n, int p) {

        String[] pow = String.valueOf(n).split("");

        double powSum = 0;
        for (int i = 0; i < pow.length ; i++) {
            powSum +=  Math.pow(Double.valueOf(pow[i]),p);
            p++;
        }

        if((powSum/n)%1==0){
            return (long) (powSum/n);
        }else {
            return -1;
        }


       /* int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], i + p)).sum();
        return sum % n == 0 ? sum / n : -1;*/
    }

    public static double findUniq(double arr[]) {

//        DoubleStream.of(arr).collect(Collectors.groupingBy())

        return arr[0];
    }
}
