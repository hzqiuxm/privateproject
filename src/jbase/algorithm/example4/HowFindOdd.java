package jbase.algorithm.example4;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/6/19 9:52
 * 几个找奇数题目
 */
public class HowFindOdd {


    /**
     * 一个数组其中有一个元素出现了一次（奇次），其他元素都出现两次（偶数次数），找出出现一次（奇次）的元素。
     * 利用异或操作直接可以得出答案
     */
    private static int findOddForOne(int[] arr){

        int length = arr.length;
        int onlyNum = arr[0];

        for (int i = 1; i < length; i++) {

            onlyNum= onlyNum^arr[i];
        }

        return onlyNum;

    }


    /**
     * 一个数组其中有两个元素出现了一次（奇次），其他元素都出现两次（偶数次数），找出出现一次（奇次）的元素
     * 1 利用异或结果将两个元素分开到不同数组  2利用单个查找的方法
     * @param arr
     * @return
     */
    private static int[] findOddForTwo(int[] arr){

        int[] result ={0,0};
        int length = arr.length;
        int sum = getSingle(arr);
        int flag = 1;

        //求出异或标识最低位为1的位置，说明从这个位置开始必定两个元素一个为1一个为0
        while(flag==1){
            if((sum&flag)!=1){
                break;
            }

            flag = flag << 1;
        }

        //元素分类并进行异或计算
        for (int i = 0; i < length; i++) {

            if((arr[i] & flag)==0){

                result[0]^=arr[i];
            }else {
                result[1]^=arr[i];
            }
        }

        return result;
    }

    /**
     * 对全部的元素进行异或得到一个异或标识值
     * @param arr 传入的数组
     * @return
     */
    private static int getSingle(int[] arr){

        if(arr.length<=0) {
            return -1;
        }

        int sum = arr[0];

        for (int i = 0; i <arr.length ; i++) {

            sum^=arr[i];
        }

        return sum;

    }



    public static void main(String[] args) {

        //32只出现一次
        int[] ints = {1,21,33,11,1,33,4,32,21,4,11};


        //32,43都只出现一次
        int[] ints2 = {43,1,21,33,11,1,33,4,32,21,4,11};

        //find odd for one
        System.out.println(findOddForOne(ints));

        //find odd for two
        int[] result = findOddForTwo(ints2);

        System.out.println(result[0] + ", " + result[1]);

    }
}
