package design_example.visitor.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public interface Visitor {
    public void visit(Man man);
    public void visit(Woman woman);
}
