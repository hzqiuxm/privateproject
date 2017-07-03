package java8new.java8InAction.strategy;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/29 0029 14:32
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validator(String s){

        return strategy.execute(s);
    }


    public static void main(String[] args) {

        Validator numberValidaor = new Validator(new IsNumeric());

        boolean b1 = numberValidaor.validator("22222");

        boolean b2 = numberValidaor.validator("aaaa");

        System.out.println("b1 = " + b1 + ", b2 = " + b2);
        System.out.println("---------------------------------------");

        Validator lowerValidator = new Validator(new IsAllLowerCase());

        boolean a1 = lowerValidator.validator("bbbbb");

        boolean a2 = lowerValidator.validator("BddCm");

        System.out.println("a1 = " + a1 + ", a2 = " + a2);
    }
}
