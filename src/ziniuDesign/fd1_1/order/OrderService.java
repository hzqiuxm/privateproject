package ziniuDesign.fd1_1.order;

public class OrderService implements IOrder{


	@Override
	public void valid(int... listOrder) {

		//1 ������������Ƿ���ȷ
		//2 ѭ������ÿ������
		//2.1 ���״̬�Ƿ����
		//2.2 �Ѷ���״̬�޸�Ϊ���ֵ�
	}

	@Override
	public void invalid(int... listOrder) {

		//1 ������������Ƿ���ȷ
		//2 ѭ������ÿ������
		//2.1 ���״̬�Ƿ����
		//2.2 �Ѷ���״̬�޸�Ϊ��Ч

	}

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {

		//1 ������������Ƿ���ȷ
		//2 ѭ������ÿ������
		//2.1 ���״̬�Ƿ����
		//3 �ѷ���Ҫ��Ķ�������WareHouse���д���
		//3.1 ����IWareHouse.dispatchOrder
		//4 �޸Ķ���״̬ΪwaitPrepare

	}

	@Override
	public void state2WaitOut(int orderId) {

	}

	@Override
	public void back(int orderid) {

	}
}
