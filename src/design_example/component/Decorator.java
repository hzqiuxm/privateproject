package design_example.component;

import java.util.Date;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 所有装饰类的父类
 */
public abstract class Decorator extends Component {

    //持有被装饰者对象
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //转调组件对象的方法
        return component.calcPrize(user,begin,end);
    }
}
