package fd3.cost;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/22 0022.
 * 装饰者公共抽象类
 */
public abstract class CostCompoent {
    public abstract double calcCost(GroupModel groupModel,Map<String,Double> mapCost);
}
