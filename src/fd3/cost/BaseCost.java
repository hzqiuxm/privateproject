package fd3.cost;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 * 被装饰的类
 */
public class BaseCost extends CostCompoent{
    @Override
    public double calcCost(GroupModel groupModel,Map<String,Double> mapCost) {
        //默认的成本为0
        return 0.0;
    }
}
