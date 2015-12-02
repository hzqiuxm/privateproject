package fd1.order;

import fd1.db.MapDB;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class OrderServiceProxy implements IOrder {
    //如果用spring框架，可以直接注入进来
    private OrderService orderService = new OrderService();

    @Override
    public void valid(int... listOrder) {
        //1:入参检查
        if(null == listOrder || listOrder.length == 0){
            return;
        }
        //2:循环处理每个订单
        //2.1：检查订单状态是否需要处理
        for(int orderid : listOrder){
            if(!((Order)MapDB.getMapDB().get("order"+orderid)).getState().equals(OrderState.waitCheck)){
                return;
            }
        }
        //调用业务模块
        orderService.valid(listOrder);

    }

    @Override
    public void invalid(int... listOrder) {
        //1:入参检查
        //2:循环处理每个订单
        //2.1：检查订单状态是否需要处理

        //转调业务模块
        orderService.invalid(listOrder);
    }

    @Override
    public void dispatchOrder(int warehouseId, int... listOrderId) {
        //1:入参检查
        //2:循环处理每个订单
        //2.1：检查订单状态是否需要处理

        orderService.dispatchOrder(warehouseId,listOrderId);
    }

    @Override
    public void state2WaitOut(int orderId) {

        orderService.state2WaitOut(orderId);
    }

    @Override
    public void back(int orderid) {

        orderService.back(orderid);
    }
}
