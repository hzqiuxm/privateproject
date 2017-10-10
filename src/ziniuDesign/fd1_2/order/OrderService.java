package ziniuDesign.fd1_2.order;

import ziniuDesign.fd1_2.Maditor;
import ziniuDesign.fd1_2.db.MapDB;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class OrderService {
    
    public void valid(int... listOrder) {

        //2.2:把订单状态修改为待分单
        for(int orderId : listOrder){
            Order o = ((Order) MapDB.getMapDB().get("order"+orderId));
            o.setState(OrderState.waitDispatch);
            MapDB.getMapDB().put("order"+orderId, o);
        }
    }


    public void invalid(int... listOrder) {

        //2.2:把订单状态修改为无效
        for(int orderId : listOrder) {
            Order o = ((Order) MapDB.getMapDB().get("order" + orderId));
            o.setState(OrderState.invalid);
            MapDB.getMapDB().put("order" + orderId, o);
        }
    }


    public void dispatchOrder(int warehouseId, int... listOrderId) {

        //修改订单的状态为等待备货waitprepare
        for(int orderId : listOrderId){
            Order o = ((Order) MapDB.getMapDB().get("order"+orderId));
            o.setWhid(warehouseId);
            o.setState(OrderState.waitPrepare);
            MapDB.getMapDB().put("order"+orderId, o);
        }
        //3：把符合要求的订单传入WareHouse进行处理
        //3.1：调用IWareHouse.dispatchOrder,采用中介者模式
        Maditor.getInstance().dispatchOrder(warehouseId,listOrderId);

    }

    public void state2WaitOut(int orderId) {
        Order o = ((Order) MapDB.getMapDB().get("order"+orderId));
        o.setState(OrderState.waitOut);
        MapDB.getMapDB().put("order"+orderId, o);
    }

    public void back(int orderid) {
        //根据状态进行相应的退货处理
        Order o = ((Order) MapDB.getMapDB().get("order"+orderid));
        if(o.getState().equals(OrderState.waitCheck)
                || o.getState().equals(OrderState.waitDispatch)
                ){
              //在订单处理模块内处理退货
        }else if(o.getState().equals(OrderState.waitPrepare)
                || o.getState().equals(OrderState.waitOut)
                ){
            //在仓库管理模块内处理退货
        }
    }
}
