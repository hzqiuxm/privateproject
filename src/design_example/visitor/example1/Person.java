package design_example.visitor.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public interface Person {
//    public void action(String state);
    public void accept(Visitor visitor);
}
