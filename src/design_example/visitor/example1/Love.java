package design_example.visitor.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public class Love implements Visitor {
    @Override
    public void visit(Man man) {
        System.out.println("当男人恋爱时，凡事......");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("当女人恋爱时，遇事......");
    }
}
