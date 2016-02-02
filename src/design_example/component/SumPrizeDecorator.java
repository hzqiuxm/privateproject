package design_example.component;

import java.util.Date;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 累计奖金计算类   部门所有奖金*0.001
 */
public class SumPrizeDecorator extends Decorator {
    public SumPrizeDecorator(Component component) {
        super(component);
    }

    public double calcPrize(String user, Date begin, Date end){
        //1.获取前面计算出的奖金
        double prePrize = component.calcPrize(user,begin,end);
        //2.计算累计奖金 这里假设已经做了汇总，部门总业务额为10000000
        double prize = 10000000 * 0.001;

        System.out.println(user+"累计奖金"+prize);

        return prePrize + prize;
    }
}
