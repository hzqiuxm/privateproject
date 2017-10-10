package ziniuDesign.fd3_2.cost;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 */
public class LiveCost extends CostCompoent {
    public static final String LIVE_ITEM = "Live";

    private CostCompoent component = null;

    public LiveCost(CostCompoent component){
        this.component = component;
    }

    @Override
    public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
        //具体业务上如何计算，这里不关心
        double cost = gm.getPersonNum() * 100;

        mapCost.put(LIVE_ITEM, cost);

        return component.calcCost(gm, mapCost) + cost;
    }
}
