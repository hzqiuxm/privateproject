package java_base.jvm;

/**
 * Created by hzqiuxm on 2016/5/31 0031.
 */
public class typeTest {

    public static void main(String[] args) {

        printMem();
    }

    /**
     * 打印出一个整型数字的二进制表示
     */
    public static void print2Bit(){

        //打印出一个整型数字的二进制表示
        int a = 6;
        for (int i = 0; i < 32; i++) {
            int t = (a&0x80000000>>>i)>>>(31-i);
            System.out.println(t);
        }
    }
    /**
     * 打印堆内存
     */
    public static void printMem(){
        //系统最大堆空间
        System.out.print("Xmx = ");
        System.out.println(Runtime.getRuntime().maxMemory()/1014.0/1024 + "M");

        //系统可用的
        System.out.print("free mem = ");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");

        //系统目前分配到的
        System.out.print("total mem = ");
        System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");
    }
}
