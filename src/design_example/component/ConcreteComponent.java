package design_example.component;

import java.util.Date;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 被装饰的原始类，可以将公共的计算在这里实现
 */
public class ConcreteComponent extends Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //为了计算方便，默认没有固定奖金
        return 0.0;
    }
}
