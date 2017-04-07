package java_encryption.mimaxue;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/21 0021 14:48
 * 线性同余法程序示例
 * R1 = (A X R0 +C )modM
 */
public class LineRandom {
    public static void main(String[] args) {

        int m = 7;
        int a = 3;
        int c = 1;
        int random = 0;
        int seed = 1;

        while(true){
            random = (a * seed + c)%m;
            seed = random;
            System.out.print(random);//2 0 1 4 6 5 .....
        }

    }
}
