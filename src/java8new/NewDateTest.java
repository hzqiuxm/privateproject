package java8new;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/10 0010 16:26
 */
public class NewDateTest {

    public static void main(String[] args) {


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime + " | " + dateTime.getHour() + " | "+ dateTime.getDayOfMonth());

        LocalDate date = LocalDate.now();
        System.out.println(date + " | " );

        LocalTime time = LocalTime.now();
        System.out.println(time);


    }
}
