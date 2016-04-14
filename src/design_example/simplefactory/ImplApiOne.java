package design_example.simplefactory;/**
 * Created by hzqiuxm on 2015/3/28.
 */

/**
 * Created by hzqiuxm on 2015/3/28.
 */
public class ImplApiOne implements Api {

    @Override
    public void test1(String s) {
        System.out.println("简单工厂测试类,第一种实现: "+s);
    }
}
