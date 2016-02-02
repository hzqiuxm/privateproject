package design_example.component;

import java.util.Date;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 团队奖金计算类 团队总结额*0.01
 */
public class GroupPrizeDecorator extends Decorator {
    public GroupPrizeDecorator(Component component) {
        super(component);
    }

    public double calcPrize(String user, Date begin, Date end){
        //1.先获取前面计算的奖金
        double money = super.calcPrize(user,begin,end);
        //2.然后计算当月团队的奖金
        double groupMoney = 0.0;
        for(double d : TempDB.mapMonthSaleMoney.values()){
            groupMoney += d;
        }

        double prize = groupMoney * 0.01;
        System.out.println(user+"当月团队业务奖金"+prize);

        return money + prize;
    }
}
