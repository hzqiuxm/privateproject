package java8new.wangwenjun.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/17 0017 20:30
 */
public class UseDate {

    public static void main(String[] args) {


//        Date date = new Date(117, 3, 8);
//        System.out.println(date);

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < 30; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        Date parase = null;

                        try {
                            parase =sdf.parse("20170505");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        System.out.println(parase);

                    }
                }
            }).start();
        }*/

        testparase();

    }


    private static void testDateFormat(){

        LocalDate localDate = LocalDate.now();

        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE); //yyyy-mm-dd

        String format2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);//yyyymmdd

        System.out.println(format1);
        System.out.println(format2);

    }

    private static void testparase(){

        String date1 = "20170508";
//        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDate localDate = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.parse(date1, df);
        System.out.println(localDate1);
    }
}
