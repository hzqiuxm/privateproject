package java8new;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by hzqiuxm on 2016/12/28 0028.
 * 实现一个Runable
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

        String [] datas = new String[] {"peng","zhang","li"};
        Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(param -> System.out.println(param));
    }

}
