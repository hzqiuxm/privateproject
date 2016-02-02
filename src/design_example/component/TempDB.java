package design_example.component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 模拟内存数据库,存放业务数据
 */
public class TempDB {
    private TempDB(){}

    public static Map<String,Double> mapMonthSaleMoney = new HashMap<String,Double>();

    static {
        mapMonthSaleMoney.put("张三",10000.0);
        mapMonthSaleMoney.put("李四",20000.0);
        mapMonthSaleMoney.put("王五",30000.0);
    }
}
