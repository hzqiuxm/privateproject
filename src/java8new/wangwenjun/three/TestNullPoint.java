package java8new.wangwenjun.three;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/18 0018 10:32
 */
public class TestNullPoint {

    public static void main(String[] args) {

//        String instanceName = getInstanceName(new Person());

//        String nameByCheck = getInstanceNameByCheck(new Person());

//        System.out.println(nameByCheck);



    }

//    private static String getInstanceName(Person person){
//
//        return person.getCar().getInsuracne().getName();
//    }

    /**
     * 待检查的方式，代码可读性低
     * @param person
     * @return
     */
//    private static String getInstanceNameByCheck(Person person){
//
//        if(null!=person){
//            Car car = person.getCar();
//            if(null!=car){
//                Insuracne ins  = car.getInsuracne();
//
//                if(null!=ins){
//
//                    return ins.getName();
//                }
//            }
//        }
//
//        return "UNKNOWN";
//    }

    /**
     * 代码可读性虽然增强了一些，但是还是很繁琐
     * @param person
     * @return
     */
//    private static String getInstanceNameByExit(Person person){
//
//        String defaultValue = "UNKNOWN";
//
//        if (null==person)
//            return defaultValue;
//        Car car = person.getCar();
//
//        if (null == car)
//            return defaultValue;
//        Insuracne ins  = car.getInsuracne();
//
//        if (null == ins)
//            return defaultValue;
//
//        return ins.getName();
//    }
}
