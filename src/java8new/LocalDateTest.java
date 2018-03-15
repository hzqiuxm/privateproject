package java8new;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/28 0028 17:02
 * 老的Date相关日期时间类对象是可变的，新的日期时间类是不可变的，我们应该使用新的日期时间相关类
 */
public class LocalDateTest {

    public static void main(String[] args) {

        //日期对象
        LocalDate localDate = LocalDate.now();
        System.out.println("当前的日期是："+ localDate);
        System.out.println("明天的日期是：" + localDate.plusDays(1));

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
        System.out.println("字符串解析后的日期是: "+ time1);

        //时区处理
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy:HH:mm:ss");
        String format = zonedDateTime.format(Formatter);

        System.out.println("时区获得时间是: " + format);

        //时间的增加减少
        System.out.println("minusDays(5) = " + localDate.minusDays(5));
        System.out.println("minusDays(-5)= " + localDate.minusDays(-5));
        System.out.println("minusHours(1)= "+ localDateTime.minusHours(1));
        System.out.println("minusSeconds(10)= " + localDateTime.minusSeconds(10));

        //获取精确时间
        System.out.println("获取精确时间:"+localDateTime.getNano());



        //-----------------------------Date与LocalDate之间转化-------------------------------------
        //Date ==> LocalDate 转化
        //1）将java.util.Date转换为ZonedDateTime。
        //2）使用它的toLocalDate（）方法从ZonedDateTime获取LocalDate。
        Date date = new Date();
        LocalDate toLocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(toLocalDate);

        //LocalDate ==> Date 之间转化
        //1）使用ZonedDateTime将LocalDate转换为Instant。
        //2）使用from（）方法从Instant对象获取Date的实例
        LocalDate localDate2 = LocalDate.now();
        Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());


    }
}
