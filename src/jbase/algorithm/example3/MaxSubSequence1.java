package jbase.algorithm.example3;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/7/3 0003 14:02
 */
public class MaxSubSequence1 {

    public static void main(String[] args) {


        MaxSubSequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4},9);
    }


   static int MaxSubSequence1(int A[], int N){
        int ThisSum,MaxSum,i,j,k;
        MaxSum = 0;

        for(i=0;i<N;i++)
        {
            for(j=i;j<N;j++)
            {
                ThisSum = 0;
                for(k=i;k<=j;k++)
                {
                    ThisSum += A[k];
                }
                if(ThisSum > MaxSum)
                    MaxSum = ThisSum;
            }
        }

       System.out.println(MaxSum);
        return MaxSum;
    }


    static int MaxSubSequence( int A[], int N)
    {
        int ThisSum,MaxSum,j;
        ThisSum = MaxSum =0;
        for(j = 0;j < N;j++)
        {

            ThisSum += A[j];

            if(ThisSum > MaxSum) {
                MaxSum = ThisSum;
            }
            else if(ThisSum < 0)
                ThisSum = 0;
        }

        System.out.println(MaxSum);
        return MaxSum;
    }


    public static int sequence(int[] arr) {
        int m = 0, a = 0, s = 0;
        for(int e : arr) {
            s += e;
            m = Math.min(s, m);
            a = Math.max(a, s - m);
        }
        return a;
    }
}
