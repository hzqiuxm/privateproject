package ziniuDesign.fd1_2.order;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public interface IOrder {
    //订单有效性核实

//    //逗逼模式 只能支持2种类型，如果后续业务有变动，比如检查订单是否在运输状态则不行
//    public void validCheck(int orderId, boolean isValid);
//
//    //初级程序员模式 只能一次一次调用，无法批量调用
//    public void validCheck(int orderId, int type);
//
//    //中级程序员模式 基本满足要求了，但写法上不够优雅
//    public void validCheck(List<Integer> listOrderId, int type);
//
//    //高级程序员模式1 倒过来，使用java语言特性，可变参数，但不满足少即是多设计原则，因为暴露了
//    //type类型，客户端必须要知道每种type类型的含义
//    public void validCheck(int type, int ... listOrderId);

    //高级程序员模式2
    public void valid(int... listOrder);
    public void invalid(int... listOrder);

    //订单分派(复杂的情况下会产生拆单操作)
    public void dispatchOrder(int warehouseId, int... listOrderId);

    //修改订单状态为待出库(不要传状态信息，暴露的越少越好)
    public void state2WaitOut(int orderId);

    //取消订单
    public void back(int orderid);

}
