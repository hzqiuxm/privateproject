package design_example.visitor.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzqiuxm on 2015/12/4 0004.
 */
public class ObjectStructure {
    private List<Person> elements = new ArrayList<Person>();
    public void attach(Person element){
        elements.add(element);
    }

    public void detach(Person element){
        elements.remove(elements);
    }

    //遍历各种具体元素，并执行它们的accept方法
    public void display(Visitor visitor){
        for(Person person : elements){
            person.accept(visitor);
        }
    }
}
