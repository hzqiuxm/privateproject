package design_example.visitor.example1;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public class Woman implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
