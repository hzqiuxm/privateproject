package java_base;

import java.math.BigDecimal;

public class Capter1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        final short s1 = 30;
        byte b = s1;

        double d1 = 0.1;
        double d2 = 0.2;

        if(d1+d2 == 0.3){
            System.out.println("我们相等");
        }

        double d = Double.parseDouble("0."+5);
        System.out.println(d);

        BigDecimal bd = new BigDecimal(d);
        System.out.println(bd);


        float f1 = 30000000;
        float f2 = f1+1;
        if(f1<f2){
            System.out.println("f1是小于f2");
        }else{
            System.out.println("你TM逗我玩呢！");
        }

    }


}
