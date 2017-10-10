package ziniuDesign.fd1_1.warehouse;

public class WareHouseService implements IWareHouse{

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {

		//1.循环为每个订单创建对应的出库单
		//2.出库单(订单的某个分支)的状态为待备货
	}

	@Override
	public void prepareOver(int outId) {


		//1.修改出库单的状态为待出库 waitOut
		//2.将订单的状态也修改为待出库 waitOut
	}
}
