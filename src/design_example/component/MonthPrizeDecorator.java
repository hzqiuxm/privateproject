package design_example.component;

import java.util.Date;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 月业务奖金计算类 月销售额*0.03
 */
public class MonthPrizeDecorator extends Decorator {

    public MonthPrizeDecorator( Component component) {
        super(component);
    }

    public double calcPrize(String user, Date begin, Date end){

        //1.先获得之前步骤计算获得的奖金
        double preMoney = super.calcPrize(user,begin,end);
        //2.计算月业务奖金
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user+"当月业务奖金"+prize);

        return preMoney + prize;
    }
}
