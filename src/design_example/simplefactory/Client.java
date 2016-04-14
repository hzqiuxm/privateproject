package design_example.simplefactory; /**
 * Created by hzqiuxm on 2015/3/28.
 */

/**
 * Created by hzqiuxm on 2015/3/28.
 */
public class Client {
    public static void main(String[] args) {
        Api api  = Factory.createApi();
        api.test1("别紧张，我只是来测试一下!");
    }
}
