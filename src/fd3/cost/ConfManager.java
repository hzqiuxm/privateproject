package fd3.cost;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 */
public class ConfManager {
    private static ConfManager cm = new ConfManager();
    private static Map<String,String> map = new HashMap<String,String>();

    private ConfManager(){

    }
    static{
        map.put(TrafficCost.TRAFFIC_ITEM, "fd3.cost.TrafficCost");
        map.put(FoodCost.FOOD_ITEM, "fd3.cost.FoodCost");
        map.put(LiveCost.LIVE_ITEM, "fd3.cost.LiveCost");
        map.put(GuidCost.GUID_ITEM, "fd3.cost.GuidCost");
    }

    public static ConfManager getInstance(){
        return cm;
    }

    public String itemClass(String item){
        return map.get(item);
    }
}
