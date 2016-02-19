package java_base;

/**
 * Created by hzqiuxm on 2016/2/19 0019.
 * 测试缓存值
 */
public class CacheTest {

    public static void main(String[] args) {
        Boolean bool1 = true;
        Boolean bool2 = true;
        Boolean bool3 = false;
        Boolean bool4 = false;
        System.out.println("bool1.equals(bool2) = " + bool1.equals(bool2));
        System.out.println("(bool1 == bool2) = "+ (bool1 == bool2));
        System.out.println("bool3.equals(bool4) = "+ bool3.equals(bool4));
        System.out.println("(bool3 == bool4) = "+ (bool3 == bool4));

        Character char1 = 127;
        Character char2 = 127;
        Character char3 = 128;
        Character char4 = 128;
        System.out.println("char1.equals(char2) = "+ char1.equals(char2));
        System.out.println("(char1 == char2) = " + (char1 == char2));
        System.out.println("char3.equals(char4) = "+ char3.equals(char4));
        System.out.println("(char3 == char4) = " + (char3 == char4));

        Integer int1 = 127;
        Integer int2 = 127;
        Integer int3 = 128;
        Integer int4 = 128;
        System.out.println("int1.equals(int2) = " + int1.equals(int2));
        System.out.println("(int1 == int2) = "+(int1 == int2));
        System.out.println("int3.equals(int4) = " + int3.equals(int4));
        System.out.println("(int3 == int4) = "+(int3 == int4));

        Long long1 = 127l;
        Long long2 = 127l;
        Long long3 = 128l;
        Long long4 = 128l;
        System.out.println("long1.equals(long2) = " + long1.equals(long2));
        System.out.println("(long1 == long2) = "+ (long1 == long2));
        System.out.println("long3.equals(long4) = " + long3.equals(long4));
        System.out.println("(long3 == long4) = "+ (long3 == long4));

        Double d1 = 127d;
        Double d2 = 127d;
        Double d3 = 128d;
        Double d4 = 128d;
        System.out.println("d1.equals(d2) = "+ d1.equals(d2));
        System.out.println("(d1 == d2) = "+ (d1 == d2));
        System.out.println("d3.equals(d4) = "+ d3.equals(d4));
        System.out.println("(d3 == d4) = "+ (d3 == d4));

    }
}
