package ziniuDesign.fd3_2.cost;

import java.util.List;

/**
 * Created by hzqiuxm on 2016/1/20 0020.
 */
public interface ICost {
    //定义接口中的方法
    //1.命名--》体现要实现的功能
    //2.确定参数
    //3.确定返回类型

    public GroupModel calcCost(int groupId, List<String> caleItems);
}
