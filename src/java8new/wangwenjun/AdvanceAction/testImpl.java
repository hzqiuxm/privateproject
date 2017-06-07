package java8new.wangwenjun.AdvanceAction;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/2 0002 10:20
 */
public class testImpl implements testInterface {

    @Override
    public void add() {

    }

    @Override
    public void update(){

        System.out.println("in impl!");
    }


    public static void main(String[] args) {


        testInterface test = new testImpl();

        test.add();
        test.delete();
        test.update();
    }
}
