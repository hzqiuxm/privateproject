package jbase.jhl.example1;

import java.util.Random;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/1 0001 15:03
 */
@Deprecated
public enum ContractEnum {

    ANY(0){
        @Override
        public ContractEnum choiceType() {

            int type = new Random().nextInt(3);
            switch (type){
                case 0 :  return LABOUR;
                case 1 :  return PERSONNEL;
                case 2 :  return HOUSE;

                default:  return LABOUR;
            }
        }
    },
    LABOUR(1){
        @Override
        public ContractEnum choiceType() {
            return LABOUR;
        }
    },   //劳动
    PERSONNEL(2){
        @Override
        public ContractEnum choiceType() {
            return PERSONNEL;
        }
    },  //人事
    HOUSE(3){
        @Override
        public ContractEnum choiceType() {
            return HOUSE;
        }
    };      //房产

    private int number;

    private ContractEnum( int number){
        this.number = number;
    }

    public int getContractEnum(){
        return number;
    }

    public void setContractEnum(int number){
        this.number = number;
    }

    public abstract ContractEnum choiceType();

}
