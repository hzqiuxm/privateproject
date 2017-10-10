package ziniuDesign.fd1_2.order;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class OrderFactory {

    private OrderFactory(){}

    public static IOrder createOrder(){
        return  new OrderServiceProxy();
    }
}
