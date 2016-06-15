package java_base.firebug;

/**
 * Created by hzqiuxm on 2016/6/14 0014.
 */
public class bugs1 {
    public static void main(String[] args) {

        String str1 = "qiuxiaomin";
        long l1 = 0;

        l1 = Long.parseLong(str1);
        l1 = Long.valueOf(str1);
    }
}
