package java_base;

/**
 * Created by hzqiuxm on 2016/2/15 0015.
 */
public class StringCompare {

    public static void main(String[] args) {

        String str1 = new String("abc");
        String str2 = new String("abc");

        StringBuffer sbf1 = new StringBuffer("abc");
        StringBuffer sbf2 = new StringBuffer("abc");

        StringBuilder sbd1 = new StringBuilder("abc");
        StringBuilder sbd2 = new StringBuilder("abc");

        System.out.println(str1.equals(str2));
        System.out.println(sbf1.equals(sbf2));
        System.out.println(sbd1.equals(sbd2));

        String s1 = "abc";
        String s2 = "def";
        String s3 = s1 + s2;
        String s4 = "abc" + s2;
        String s5 = s1 + "def";

        System.out.println("s3 == s4? "+(s3==s4));
        System.out.println("s3 == s5?"+(s3==s5));
        System.out.println("s4 == s5?"+(s4==s5));

        System.out.println("s3.intern() == s4.intern()"+(s3.intern() == s4.intern()));
        System.out.println("s3.intern() == s5.intern()"+(s3.intern() == s5.intern()));
        System.out.println("s4.intern() == s5.intern()"+(s4.intern() == s5.intern()));

    }
}
