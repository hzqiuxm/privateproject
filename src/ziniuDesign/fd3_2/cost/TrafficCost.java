package ziniuDesign.fd3_2.cost;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 * 计算交通费
 */
public class TrafficCost extends CostCompoent {
    public static final String TRAFFIC_ITEM = "Traffic";
    private CostCompoent costCompoent = null;

    public TrafficCost(CostCompoent costCompoent) {
        this.costCompoent = costCompoent;
    }

    @Override
    public double calcCost(GroupModel groupModel, Map<String,Double> mapCost) {
        //这里可以引入策略模式
        //与可以引入解释器模式

        double cost = groupModel.getPersonNum() * 100;
        mapCost.put(TRAFFIC_ITEM,cost);
        return costCompoent.calcCost(groupModel, mapCost) + cost;
    }
}
