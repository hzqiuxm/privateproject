package jbase.algorithm.example2;

import java.util.Stack;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/7 0007 15:52
 */
public class GoStairs {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<Integer> stack=new Stack<Integer>();
        climb(stack,10);
    }

    public static void climb(Stack<Integer> stack,int totalStep){
        if (totalStep>=1){
            stack.push(1);
            climb(stack,totalStep-1);
            stack.pop();
        }
        if (totalStep>=2){
            stack.push(2);
            climb(stack,totalStep-2);
            stack.pop();
        }
        if (totalStep>=3){
            stack.push(3);
            climb(stack,totalStep-3);
            stack.pop();
        }
        if (totalStep==0){
            for (int i:stack
                    ) {
                System.out.print(i+"->");
            }
            System.out.println("OK");
        }
    }
}
