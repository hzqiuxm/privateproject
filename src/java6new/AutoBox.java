package java6new;

/**
 * Created by qiuding on 2017/3/19.
 * 基本数据类型自动装箱拆箱
 */
public class AutoBox {
    public static void main(String[] args) {

        Integer iObj = 12; //JDK1.5以前是不行的

        Integer a = 3;
        Integer b = 3;

        System.out.println(a==b);//true 一个字节内的数值对象是在缓存池里的（享元模式）

        Integer c = 129;
        Integer d = 129;

        System.out.println(c==d);//false 超过一个字节



    }
}
