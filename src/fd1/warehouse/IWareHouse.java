package fd1.warehouse;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public interface IWareHouse {
    //订单分发
    public void dispatchOrder(int warehouseId, int... listOrderId);

    //准备出库
    public void prepaerOver(int outId);

    //退货
    public void backOrder(int warehouseId,int orderId);
}
