package java8new.java8InAction.strategy;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/29 0029 14:38
 */
public class LambdaStrategy {

    public static void main(String[] args) {


        Validator numberValidator = new Validator((String s)-> s.matches("[a-z]+"));

        boolean b1 = numberValidator.validator("22222");

        boolean b2 = numberValidator.validator("aaaa");

        System.out.println("b1 = " + b1 + ", b2 = " + b2);
        System.out.println("---------------------------------------");

        Validator lowerValidator = new Validator((String s)->s.matches("\\d+"));

        boolean a1 = lowerValidator.validator("bbbbb");

        boolean a2 = lowerValidator.validator("BddCm");

        System.out.println("a1 = " + a1 + ", a2 = " + a2);
    }
}
