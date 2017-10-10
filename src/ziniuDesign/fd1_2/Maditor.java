package ziniuDesign.fd1_2;


import ziniuDesign.fd1_2.order.OrderFactory;
import ziniuDesign.fd1_2.warehouse.WHFactory;

/**
 * Created by hzqiuxm on 2015/12/2 0002.
 */
public class Maditor {

    private  Maditor(){}
    private static Maditor maditor = new Maditor();

    public static Maditor getInstance(){
        return maditor;
    }

    //订单调仓库
    public void dispatchOrder(int warehouseId, int... listOrderId){
        WHFactory.createWareHouse().dispatchOrder(warehouseId,listOrderId);
    }

    //仓库调订单
    public void state2WaritOut(int orderId){
        OrderFactory.createOrder().state2WaitOut(orderId);
    }
}
