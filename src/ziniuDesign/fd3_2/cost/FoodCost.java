package ziniuDesign.fd3_2.cost;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 * 计算吃饭费用
 */
public class FoodCost extends CostCompoent {
    public static final String FOOD_ITEM = "Food";

    private CostCompoent component = null;

    public FoodCost(CostCompoent component){
        this.component = component;
    }

    @Override
    public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
        //具体业务上如何计算，这里不关心
        double cost = gm.getPersonNum() * 15;

        mapCost.put(FOOD_ITEM, cost);

        return component.calcCost(gm, mapCost) + cost;
    }
}
