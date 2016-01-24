package fd7.db;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzqiuxm on 2015/12/1 0001.
 */
public class MapDB {
    private static Map map = new HashMap();
    private MapDB(){}

    public static Map getMapDB(){
        return map;
    }

}
