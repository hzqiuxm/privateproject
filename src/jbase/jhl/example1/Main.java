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

    public static void main(String[] args) {


        List<Contract> contractList = getRandomContracts(100);

        int laborFeeTotal = contractList.stream()
                                        .filter(contract -> contract.getContractEnum() == ContractEnum.LABOUR)
                                        .mapToInt(Contract::getInsuranceFee)
                                        .sum();

        System.out.println("劳动合同的总保险金额是: " + laborFeeTotal);


        double houseAverageFee = contractList.stream()
                                            .filter(contract -> contract.getContractEnum() == ContractEnum.HOUSE)
                                            .mapToInt(Contract::getInsuranceFee)
                                            .average().getAsDouble();

        System.out.println("房产类合同的保险平均金额是：" + houseAverageFee);


        List<Contract> personnelList = contractList.stream()
                                                    .filter(contract -> contract.getContractEnum() == ContractEnum.PERSONNEL)
                                                    .collect(Collectors.toList());

        System.out.println( "人事类合同集合清单 ： " + personnelList + " 总计：" + personnelList.size());



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
        contract.setContractEnum(ContractEnum.ANY.choiceType());
        contract.setInsuranceFee(new Random().nextInt(10000));

        return contract;
    }

}
