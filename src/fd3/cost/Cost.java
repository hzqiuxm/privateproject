package fd3.cost;

import fd3.db.MapDB;

import java.util.List;

/**
 * Created by hzqiuxm on 2016/1/20 0020.
 */
public class Cost implements ICost {
    @Override
    public GroupModel calcCost(int groupId, List<String> caleItems) {
        GroupModel gm = (GroupModel) MapDB.getMapDB().get(groupId);
        gm.calcCost(caleItems);
        return gm;
    }
}
