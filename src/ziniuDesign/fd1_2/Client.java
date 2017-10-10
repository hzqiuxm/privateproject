package ziniuDesign.fd1_2;


import ziniuDesign.fd1_2.db.MapDB;
import ziniuDesign.fd1_2.order.Order;
import ziniuDesign.fd1_2.order.OrderFactory;
import ziniuDesign.fd1_2.order.OrderState;
import ziniuDesign.fd1_2.warehouse.WHFactory;
import ziniuDesign.fd1_2.warehouse.WareHouse;

/**
 * Created by hzqiuxm on 2015/12/2 0002.
 */
public class Client {
    public static void main(String[] args) {
        Order o1 = new Order();
        o1.setId(1);
        o1.setState(OrderState.waitCheck);

        Order o2 = new Order();
        o2.setId(2);
        o2.setState(OrderState.waitCheck);

        MapDB.getMapDB().put("order"+o1.getId(), o1);
        MapDB.getMapDB().put("order"+o2.getId(), o2);

        WareHouse wh1 = new WareHouse();
        wh1.setId(1);
        wh1.setName("wh 1");
        MapDB.getMapDB().put("wh"+wh1.getId(), wh1);


        OrderFactory.createOrder().valid(1);
        printMapDB("valid");
        OrderFactory.createOrder().dispatchOrder(1, 1);
        printMapDB("dispatchOrder");
        WHFactory.createWareHouse().prepaerOver(1);
        printMapDB("prepareOver");
    }

    private static void printMapDB(String str){
        System.out.println(str+"================================");
        for(Object key : MapDB.getMapDB().keySet()){
            System.err.println("key="+key+" , value="+MapDB.getMapDB().get(key));
        }
    }
}
