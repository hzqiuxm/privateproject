package codewars;

import java.util.Arrays;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/22 0022 15:27
 * A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n.
 * If that value has two digits, continue reducing in this way until a single-digit number is produced.
 * This is only applicable to the natural numbers.
 * digital_root(942)
=> 9 + 4 + 2
=> 15 ...
=> 1 + 5
=> 6
/*       while(n > 9){
n = n/10 + n % 10;
}
return(n);
}*/

public class DRoot {

    public static void main(String[] args) {

        System.out.println(digital_root(999));

    }


    public static int digital_root(int n) {

        int i = n;
        while(i>9){
           i =  toRoot(i);
        }

        return i;



    }


    public static int toRoot(int num){

        String[] strings = String.valueOf(num).split("");

        return Arrays.stream(strings).mapToInt(i->Integer.valueOf(i)).reduce((a,b)->a+b).getAsInt();
    }
}
