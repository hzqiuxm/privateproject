package jbase.jhl.example4;

import java8new.wangwenjun.one.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/13 0013 10:27
 */



public class Main {
    private static final String LABOUR_TYPE ="labour";
    private static final String HOUSE_TYPE ="house";
    private static final String PERSONNEL_TYPE ="personnel";


    public static void main(String[] args) {

        List<Contract> contractList = initContract();

        //找出金额大于10000的劳动合同
        filterContrats(contractList,(contract)->contract.getPrice()>10000 && LABOUR_TYPE.equals(contract.getType())).stream().forEach(System.out::println);


    }


    public static List<Contract> filterContrats(List<Contract> contracts, Predicate<Contract> predicate ){

        List<Contract> contractList = new ArrayList<>();

        for (Contract contract : contracts){
            if (predicate.test(contract)){
                contractList.add(contract);
            }
        }

        return contractList;

    }

    //初始化合同6份，2份劳动，2份房产，2份人事
    private static List<Contract> initContract(){


        return Arrays.asList(
                new Contract(1, "XXX劳动合同1", LABOUR_TYPE, 10000),
                new Contract(2, "XXX劳动合同2", LABOUR_TYPE, 30000),
                new Contract(3, "XXX人事合同1", PERSONNEL_TYPE, 20000),
                new Contract(4, "XXX人事合同2", PERSONNEL_TYPE, 50000),
                new Contract(5, "XXX房地产合同1", HOUSE_TYPE, 40000),
                new Contract(6, "XXX房地产合同2", HOUSE_TYPE, 60000)
        );


    }



}
