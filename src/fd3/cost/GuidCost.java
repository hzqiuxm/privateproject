package fd3.cost;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 * 计算导游费
 */
public class GuidCost extends CostCompoent{
    public static final String GUID_ITEM = "GUID";

    private CostCompoent component = null;

    public GuidCost(CostCompoent component){
        this.component = component;
    }

    @Override
    public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
        //具体业务上如何计算，这里不关心
        double cost = gm.getPersonNum() * 10;

        mapCost.put(GUID_ITEM, cost);

        return component.calcCost(gm, mapCost) + cost;
    }
}
