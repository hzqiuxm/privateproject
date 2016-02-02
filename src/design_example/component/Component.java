package design_example.component;

import java.util.Date;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 计算奖金的公共的接口或抽象类
 */
public abstract class Component {

    public abstract double calcPrize(String user, Date begin, Date end);
}
