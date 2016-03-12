package java_base;

import java.util.Calendar;

/**
 * Created by hzqiuxm on 2016/3/4 0004.
 */
public class Jdk8Date {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1975,Calendar.MARCH,31,23,59,59);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().getTime());
        calendar.add(Calendar.SECOND,1);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().getTime());
    }
}
