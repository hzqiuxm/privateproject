package ziniuDesign.fd1_2.warehouse;

import ziniuDesign.fd1_2.Maditor;
import ziniuDesign.fd1_2.db.MapDB;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class WareHouseService implements IWareHouse {
    @Override
    public void dispatchOrder(int warehouseId, int... listOrderId) {
        //1.循环为每个订单创建对应的出库单
        int count = 1;
        for (int orderId : listOrderId) {
            Out out = new Out();
            out.setId(count++);
            out.setOrderId(orderId);
            out.setWhId(warehouseId);
            //2.出库单(订单的某个分支)的状态为待备货
            out.setState(WareHouseState.waitPrepare);
            MapDB.getMapDB().put("out" + out.getId(), out);

        }
    }

        @Override
        public void prepaerOver(int outId){
            //1.修改出库单的状态为待出库 waitOut
            Out out = (Out) MapDB.getMapDB().get("out"+outId);
            out.setState(WareHouseState.waitOut);
            MapDB.getMapDB().put("out"+out.getId(),out);

            //2.将订单的状态也修改为待出库 waitOut
            //采用中介者模式
            Maditor.getInstance().state2WaritOut(out.getOrderId());
        }

    @Override
    public void backOrder(int warehouseId, int orderId) {

    }

}
