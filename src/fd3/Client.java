package fd3;

import fd3.cost.*;
import fd3.db.MapDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzqiuxm on 2015/12/6 0006.
 */
public class Client {
    public static void main(String[] args) {
        GroupModel gm = new GroupModel();
        gm.setId(1);
        gm.setPersonNum(12);

        MapDB.getMapDB().put(gm.getId(), gm);


        List<String> list = new ArrayList<String>();
        list.add(TrafficCost.TRAFFIC_ITEM);

        GroupModel gm2 = CostFactory.createICost().calcCost(gm.getId(), list);
        System.out.println("gm2=="+gm2);

        list.add(LiveCost.LIVE_ITEM);
        gm2 = CostFactory.createICost().calcCost(gm.getId(), list);
        System.out.println("gm2=="+gm2);

        list.add(FoodCost.FOOD_ITEM);
        gm2 = CostFactory.createICost().calcCost(gm.getId(), list);
        System.out.println("gm2=="+gm2);
    }
}
