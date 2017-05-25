package jbase.jhl.example1;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/1 0001 15:09
 */

public class Main {

    private static final String LABOUR_TYPE ="labour";
    private static final String HOUSE_TYPE ="house";
    private static final String PERSONNEL_TYPE ="personnel";

    public static void main(String[] args) {


        List<Contract> contractList = getRandomContracts(100);

        Map<String,List<Contract>> map = contractList.stream().collect(Collectors.groupingBy(Contract::getContractType));

        int laborFeeTotal = map.get(LABOUR_TYPE).stream()
                .mapToInt(Contract::getInsuranceFee)
                .sum();

        System.out.println("劳动合同的总保险金额是: " + laborFeeTotal);


        double houseAverageFee = map.get(HOUSE_TYPE).stream()
                                            .mapToInt(Contract::getInsuranceFee)
                                            .average().getAsDouble();

        System.out.println("房产类合同的保险平均金额是：" + houseAverageFee);


        List<Contract> personalContracts = map.get(PERSONNEL_TYPE);
        personalContracts.sort(Comparator.comparing(Contract::getInsuranceFee));

        System.out.println( "人事类合同集合清单 ： " + personalContracts);



    }


    public static List<Contract> getRandomContracts(int number){

        List<Contract> contracts = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            contracts.add(createContract());
        }

        return contracts;
    }


    public static Contract createContract(){

        String conId = String.valueOf(Math.abs(new Random().nextInt()));
        Contract contract = new Contract();
        contract.setContractId(conId);
        contract.setContractName("随机类合同"+conId);
        contract.setContractType(getContractType());
        contract.setInsuranceFee(new Random().nextInt(10000));

        return contract;
    }

    private static String getContractType(){


        int ctype = new Random().nextInt(3);

        switch (ctype){
            case 0 :  return LABOUR_TYPE;
            case 1 :  return PERSONNEL_TYPE;
            case 2 :  return HOUSE_TYPE;

            default:  return LABOUR_TYPE;
        }
    }

}
