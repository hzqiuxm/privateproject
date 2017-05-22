package java8new.wangwenjun.three;

import java.util.Optional;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/18 0018 10:05
 */
public class UseOptional {

    public static void main(String[] args) {

//        Optional<Insuracne> insuracneOptional = Optional.empty();
//        insuracneOptional.get();//会报错

//        Optional<Insuracne> insuracneOptional1 = Optional.of(new Insuracne());
//        insuracneOptional1.get();
//
//        Optional<Insuracne> insuracneOptional2 = Optional.ofNullable(null);
//        insuracneOptional2.orElseGet(Insuracne::new);
//        insuracneOptional2.orElse(new Insuracne());
//        insuracneOptional2.orElseThrow(RuntimeException::new);


    }

    /**
     * 传统方式
     * @param insuracne
     * @return
     */
    private static String getInsuranceName(Insuracne insuracne){
        if(null == insuracne)
            return "unknow";
        return insuracne.getName();
    }

    /**
     * 使用optional方式
     * @param insuracne
     * @return
     */
    private static String getInsturanceNameByOptional(Insuracne insuracne){
        return Optional.ofNullable(insuracne).map(Insuracne::getName).orElse("unknown");
    }

}
