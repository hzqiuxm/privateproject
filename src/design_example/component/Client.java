package design_example.component;

/**
 * Created by hzqiuxm on 2016/2/2 0002.
 * 使用装饰者模式的客户端
 */
public class Client {
    public static void main(String[] args) {
        //先创建计算基本奖金的类
        Component component = new ConcreteComponent();

        //开始分别计算
        //先组合普通业务人员
        Decorator decoratorMonth = new MonthPrizeDecorator(component);
        Decorator decoratorSum = new SumPrizeDecorator(decoratorMonth);

        double zs = decoratorSum.calcPrize("张三",null,null);
        System.out.println("张三获得的奖金是: "+zs);

        double ls = decoratorSum.calcPrize("李四",null,null);
        System.out.println("李四获得的奖金是: "+ls);

        //业务经理王五获得的奖金
        Decorator decoratorgroup = new GroupPrizeDecorator(decoratorSum);
        double ww = decoratorgroup.calcPrize("王五",null,null);
        System.out.println("王五经理获得的奖金是："+ww);

    }
}
