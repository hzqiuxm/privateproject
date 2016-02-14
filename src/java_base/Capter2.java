package java_base;

/**
 * Created by hzqiuxm on 2016/2/4 0004.
 */
public class Capter2 {
    public static void main(String[] args) {
        //1.三个加号的测试
        int i = 10;
        int j = 20;
        int k = i+++j;
        System.out.println("i= "+i);
        System.out.println("j= "+j);
        System.out.println("k= "+k);

        String s = "\171";
        System.out.println(s);

        //2.前缀++和后缀++
        int a = 15;
        a = a++;
        int b = a;
        System.out.println("a = "+a);
        System.out.println("b = "+ ++b);

        //3.移位运算 <<左移  >>右移  >>>无符号右移
        int a2 = 2;
        long a3 = 64;
        System.out.println(a2 << 32);
        System.out.println(a3 >> 64);
        System.out.println(a2 >> -10);
        System.out.println(a3 << -10);

        //4.移位与乘除运算
        int a4 = -9;
        System.out.println(a4 >> 1);
        System.out.println(a4/2);

        //5.复合运算
        System.out.println("================5==============");
        Capter2 capter2 = new Capter2();
        int i1 = 10;
        capter2.test(i1,++i1,i1=2);
        capter2.test(i1 = 5,i1++,i1);

    }

    public void test(int x, int y, int z){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
