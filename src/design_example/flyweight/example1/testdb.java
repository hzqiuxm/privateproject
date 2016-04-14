package design_example.flyweight.example1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hzqixm on 2015/7/18.
 * 模拟数据库数据
 */
public class testdb {

    public static Collection<String> colDB = new ArrayList<String>();

    static {
        colDB.add("张三,人员列表,查看");
        colDB.add("李四,人员列表,查看");
        colDB.add("李四,薪资数据,查看");
        colDB.add("李四,薪资数据,修改");

        for (int i=0; i<3; i++) {
            colDB.add("张三"+i+",人员列表,查看");
        }

    }
}
