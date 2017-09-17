package java_base.youhua;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/7/7 0007 14:32
 */
public class StringSplit {

    public static void main(String[] args) {


        String orgStr = null;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 10000; i++) {
            sb.append(i);
            sb.append(",");
        }


        System.out.println("------------------------------");
        orgStr = sb.toString();

        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            orgStr.split(",");
//        }

        long end = System.currentTimeMillis();

        System.out.println("原始split : " + (end-start));



        start = System.currentTimeMillis();

        String orgStr2= sb.toString();
        String temp = orgStr2;
        while (true){
            String splitStr = null;
            int j = temp.indexOf(",");
            if(j<0) break;
            splitStr = temp.substring(0,j);
            temp = temp.substring(j+1);

        }
        temp = orgStr2;
        end = System.currentTimeMillis();
        System.out.println("自定义分割 : " + (end-start));


    }
}
