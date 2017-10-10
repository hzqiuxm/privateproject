package ziniuDesign.fd1_1.order;

public class OrderService implements IOrder{


	@Override
	public void valid(int... listOrder) {

		//1 检查输入数据是否正确
		//2 循环处理每个订单
		//2.1 检查状态是否合理
		//2.2 把订单状态修改为待分单
	}

	@Override
	public void invalid(int... listOrder) {

		//1 检查输入数据是否正确
		//2 循环处理每个订单
		//2.1 检查状态是否合理
		//2.2 把订单状态修改为无效

	}

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {

		//1 检查输入数据是否正确
		//2 循环处理每个订单
		//2.1 检查状态是否合理
		//3 把符合要求的订单传入WareHouse进行处理
		//3.1 调用IWareHouse.dispatchOrder
		//4 修改订单状态为waitPrepare

	}

	@Override
	public void state2WaitOut(int orderId) {

	}

	@Override
	public void back(int orderid) {

	}
}
