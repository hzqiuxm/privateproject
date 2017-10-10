package ziniuDesign.fd3_2.cost;

import ziniuDesign.fd3_2.db.MapDB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/25 0025.
 */
public class FlyWeightFactory {
    private static Map<Integer, GroupModel> map = new HashMap<Integer, GroupModel>();
    private FlyWeightFactory(){

    }
    public static GroupModel getFlyweight(int groupId){
        //Java缓存的基本写法
        Object obj = map.get(groupId);
        GroupModel gm = null;
        if(obj!=null){
            gm = (GroupModel)obj;
        }else{
            gm = (GroupModel) MapDB.getMapDB().get(groupId);
            map.put(groupId, gm);
        }
//		return (GroupModel)gm.clone();
        return gm;
    }
}
