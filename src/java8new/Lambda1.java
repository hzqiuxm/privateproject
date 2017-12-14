package java8new;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by hzqiuxm on 2016/12/28 0028.
 * 实现一个Runable
 * 使用前提：任何有函数式接口（只有一个抽象方法）的地方，默认方法不算,类方法不算，Object中有的方法
 * Lambda表达式好处：类型推导，简洁；学习技巧：熟悉泛型，多练
 */
public class Lambda1 {

    public static void main(String[] args) {

        int i = 0;
        //传统方式
        new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名内部类实现的Runable接口");
                System.out.println("i="+i);
            }
        }.run();

        int j=1;
        Runnable r = ()->{
            System.out.println("使用Lambda实现的Runable接口");
            System.out.println("j="+j);
        };
        r.run();

        //字符串数组排序
        String [] datas = new String[] {"peng","zhang","li"};
        Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(param -> System.out.println(param));
    }

}
