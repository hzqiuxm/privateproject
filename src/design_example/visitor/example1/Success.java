package design_example.visitor.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public class Success implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.println("当女人成功时，背后大多有一个不成功的男人");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("当女人成功时，背后大多有一个不成功的男人");
    }
}
