package java8new;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/28 0028 17:02
 */
public class LocalDateTest {

    public static void main(String[] args) {

        //日期对象
        LocalDate localDate = LocalDate.now();
        System.out.println("当前的日期是："+ localDate);

        //时间对象
        LocalTime localTime = LocalTime.now();
        System.out.println("当前的时间是: "+ localTime);

        //日期时间对象
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前的日期时间是：" + localDateTime);

        //字符串解析为日期对象
        String strDate = "2016-12-28 17:11:38";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time1 = LocalDateTime.parse(strDate,dateTimeFormatter);
        System.out.println("字符串解析后的日期是:"+ time1);

        //时区处理
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy:HH:mm:ss");
        String format = zonedDateTime.format(Formatter);

        System.out.println("市区获得时间是:" + format);

    }
}