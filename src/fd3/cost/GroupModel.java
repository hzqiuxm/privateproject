package fd3.cost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzqiuxm on 2016/1/20 0020.
 */
public class GroupModel {
    private int id;

    //返回计算数据
    //key --计算项名称  value --计算成本
    private Map<String,Double> mapcost = new HashMap<String,Double>();

    public void calcCost(List<String> calcItems){
        //反射来动态组装
        //结果存储的mapcost中
    }

    //领域对象==》某个具体业务对象
    //领域设计是纯粹的面向对象的方式
    //pojo是出血模式，属性+get/set +数据的存取实现
    //领域设计的基本思想  pojo+领域对象的业务功能
    //就像一个业务小模块
    //对象较少，当业务越复杂，整体结构会更清晰，业务流程更易理解与实现
    //从实现角度，对人员的面向对象思想比较高
    //处理多个业务对象之间相互有关系的时候，不是很好处理
    //不利于分层，不利于工作量划分

    //变化
    //vo====〉属性+getter/setter ====〉Entity Object ， DTO  ，TO ， VO
    //dao===〉数据存取的实现
    //service===> 领域对象的业务功能 ，
    //如果说这个功能可以在领域对象内部完成，而不涉及跟其他领域对象交互，那么就实现在领域对象里面，在Service里面直接调用就可以了
    //需要涉及跟其他领域对象交互的时候，把这样的功能，放到service里面来实现，这个时候，service类似一个中介者


}
