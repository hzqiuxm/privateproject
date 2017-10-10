package ziniuDesign.fd3_2.cost;

import java.util.List;

/**
 * Created by hzqiuxm on 2016/1/20 0020.
 */
public class CostService implements ICost {
    @Override
    public GroupModel calcCost(int groupId, List<String> calcItems) {
        GroupModel gm = FlyWeightFactory.getFlyweight(groupId);
        gm.calcCost(calcItems);
        return gm;
    }
}
